package org.yash.deltafuse.dataingestion.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.yash.deltafuse.dataingestion.constant.ScheduleConstant;
import org.yash.deltafuse.dataingestion.model.FileData;
import org.yash.deltafuse.dataingestion.service.FTPService;
import org.yash.deltafuse.dataingestion.service.FileUploadService;
import org.yash.deltafuse.dataingestion.service.TaskSchedularService;

@RestController
public class DataInjectionController {

	@Autowired
	private FileUploadService fileUploadService;
	
	@Autowired
	private TaskSchedularService taskSchedularService;
	
	@Autowired
	private FTPService ftpService;

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
	 
	@GetMapping(path = "/api/v1/schedule")
	public void initializeScheduler() {
		Map<String, String> inputs = new HashMap();
		inputs.put(ScheduleConstant.SCHEDULER_TYPE, "daily");
		inputs.put(ScheduleConstant.DATE, "21-03-2019");
		inputs.put(ScheduleConstant.TIME, "14:05");
		inputs.put(ScheduleConstant.START_DATE, "21");
		
		/*try {
			ftpService.listFTPFiles("/");
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		taskSchedularService.initializeScheduler(inputs);
		
		
	}
}
