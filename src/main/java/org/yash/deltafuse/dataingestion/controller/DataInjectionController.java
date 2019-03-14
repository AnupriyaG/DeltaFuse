package org.yash.deltafuse.dataingestion.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.yash.deltafuse.dataingestion.model.FileData;
import org.yash.deltafuse.dataingestion.service.FileUploadService;

@RestController
public class DataInjectionController {

	@Autowired
	private FileUploadService fileUploadService;

	@PostMapping(path = "/api/v1/upload")
	public List<FileData> getFile(@RequestParam("file") MultipartFile file) {
		List<FileData> fileData = null;
		try {
			fileData = fileUploadService.readExcelFile(file.getInputStream());
			if(null!=fileData){
				fileUploadService.saveData(fileData);
			}
		} catch (IOException io) {
			io.printStackTrace();
		}
		return fileData;
	}
	
	@PostMapping(path = "/api/v1/fetch")
	public List<FileData> getItemC() {
		return fileUploadService.getItemC();
	}
	 
}
