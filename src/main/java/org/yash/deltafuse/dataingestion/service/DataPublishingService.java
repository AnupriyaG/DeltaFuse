package org.yash.deltafuse.dataingestion.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.yash.deltafuse.dataingestion.model.HighDemand;

@Service
public interface DataPublishingService {

	public List<HighDemand> getAllData();

	public List<HighDemand> addAllData(List<HighDemand> highDemand);

	public void deleteAllData();  

}
