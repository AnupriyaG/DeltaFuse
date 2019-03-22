package org.yash.deltafuse.dataingestion.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.yash.deltafuse.dataingestion.model.HighDemand;
import org.yash.deltafuse.dataingestion.repository.DataRepository;
import org.yash.deltafuse.dataingestion.service.DataPublishingService;

@Component("dataPublishingService")
public class DataPublishingServiceImpl implements DataPublishingService{

	@Autowired
    private DataRepository dta;
	
	@Override
	public List<HighDemand> getAllData() {
		return dta.findAll();
	}

	@Override
	public List<HighDemand> addAllData(List<HighDemand> highDemand) {
		return (List<HighDemand>) dta.saveAll(highDemand);
	}

	@Override
	public void deleteAllData() {
		dta.deleteAll();
	}

}
