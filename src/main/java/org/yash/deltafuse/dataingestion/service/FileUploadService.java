package org.yash.deltafuse.dataingestion.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Service;
import org.yash.deltafuse.dataingestion.model.FileData;

@Service
public interface FileUploadService {

	public List<FileData> readExcelFile(InputStream inputStream) throws IOException;

	public void saveData(List<FileData> fileData);

	public List<FileData> getItemC();
}
