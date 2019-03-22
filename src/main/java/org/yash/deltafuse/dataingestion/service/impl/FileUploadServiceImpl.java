package org.yash.deltafuse.dataingestion.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.yash.deltafuse.dataingestion.model.FileData;
import org.yash.deltafuse.dataingestion.repository.CassandraFileRepository;
import org.yash.deltafuse.dataingestion.service.FileUploadService;

@Component("fileUploadService")
public class FileUploadServiceImpl implements FileUploadService  {

	@Autowired
	private CassandraFileRepository fileRepository;
	
	@Override
	public List<FileData> readExcelFile(InputStream inputStream) throws IOException {
		Map<String,String> resultMap = null; 
		FileData fileData = null;
		List<FileData> fileDatalist = new ArrayList();
		try {
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet datatypeSheet = workbook.getSheetAt(0);
			
			Iterator<Row> iterator = datatypeSheet.iterator();
			List<String> keys = new ArrayList<String>();
			while (iterator.hasNext()) {
				fileData = new FileData();
				Row currentRow = iterator.next();
				Iterator<Cell> cellIterator = currentRow.iterator();
				if (null != keys && !keys.isEmpty()) {
					fileData.setId(UUID.randomUUID());
					resultMap = new HashMap();
					while (cellIterator.hasNext()) {
						Cell currentCell = cellIterator.next();
						currentCell.getColumnIndex();
						
						if (currentCell.getCellTypeEnum() == CellType.STRING) {
							resultMap.put(keys.get(currentCell.getColumnIndex()), currentCell.getStringCellValue());
							System.out.print(currentCell.getStringCellValue() + "--");
						} else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
							resultMap.put(keys.get(currentCell.getColumnIndex()), String.valueOf(currentCell.getNumericCellValue()));
							System.out.print(currentCell.getNumericCellValue() + "--");
						}
					}
					fileData.setMobile(resultMap);

				} else {
					while (cellIterator.hasNext()) {
						Cell currentCell = cellIterator.next();
						currentCell.getColumnIndex();
						keys.add(currentCell.getStringCellValue());
					}
				}
					if(null!=fileData.getId())
						fileDatalist.add(fileData);
				System.out.println();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileDatalist;
	}

	@Override
	public void saveData(List<FileData> fileData) {
		fileRepository.saveAll(fileData);
	}

	@Override
	public List<FileData> getItemC() {
		List<FileData> data = fileRepository.findAll();
		//filter the data here validate data
		return data;
	}

}
