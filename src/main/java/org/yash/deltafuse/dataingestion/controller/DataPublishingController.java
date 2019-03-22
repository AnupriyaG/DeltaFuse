package org.yash.deltafuse.dataingestion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.yash.deltafuse.dataingestion.model.HighDemand;
import org.yash.deltafuse.dataingestion.service.DataPublishingService;

@RestController
public class DataPublishingController {

	@Autowired
	private DataPublishingService dataPublishingService;

	@PostMapping(path = "/api/v1/getAllData")
    public List<HighDemand> getAllData(){
        return dataPublishingService.getAllData();
    }

	@PostMapping(path = "/api/v1/addAllData")
    public List<HighDemand> addAllData(@RequestBody List<HighDemand> highDemand){
		return dataPublishingService.addAllData(highDemand);
    }

	@PostMapping(path = "/api/v1/deleteAllData")
    public void deteteAllData(){
		dataPublishingService.deleteAllData();
    }
}
