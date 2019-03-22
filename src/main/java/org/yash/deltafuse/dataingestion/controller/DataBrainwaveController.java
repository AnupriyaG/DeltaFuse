package org.yash.deltafuse.dataingestion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yash.deltafuse.dataingestion.model.FileData;
import org.yash.deltafuse.dataingestion.service.DataDiscoveryService;

@RestController
public class DataBrainwaveController {

	@Autowired
	private DataDiscoveryService dataDiscoveryService;

	@PostMapping(path = "/api/v1/sales")
	public List<FileData> getSalesDiscovery() {
		return dataDiscoveryService.getSalesDiscovery();
	}
	
	@PostMapping(path = "/api/v1/price")
	public List<FileData> getPriceDiscovery() {
		return dataDiscoveryService.getPriceDiscovery();
	}
}
