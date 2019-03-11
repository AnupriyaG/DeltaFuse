package org.yash.deltafuse.dataingestion.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.yash.deltafuse.dataingestion.service.FileUploadService;

@RestController
public class DataInjectionController {

	@Autowired
	private FileUploadService fileUploadService;

	@PostMapping(path = "/api/v1/upload")
	public void getFile(@RequestParam("file") MultipartFile file) {
		try {
			fileUploadService.readExcelFile(file.getInputStream());
		} catch (IOException io) {
			io.printStackTrace();
		}
	}
}
