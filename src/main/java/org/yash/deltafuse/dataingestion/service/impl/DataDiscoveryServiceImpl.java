package org.yash.deltafuse.dataingestion.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.yash.deltafuse.dataingestion.model.FileData;
import org.yash.deltafuse.dataingestion.repository.CassandraFileRepository;
import org.yash.deltafuse.dataingestion.service.DataDiscoveryService;

@Component("dataDiscoveryService")
public class DataDiscoveryServiceImpl implements DataDiscoveryService {

	@Autowired
	private CassandraFileRepository fileRepository;
	
	@Override
	public List<FileData> getPriceDiscovery() {
		List<FileData> data = fileRepository.findAll();
		//filter the data here validate data
		return data;
	}
	
	@Override
	public List<FileData> getSalesDiscovery() {
		List<FileData> data = fileRepository.findAll();
		//filter the data here validate data
		List<FileData> finalData = null;
		if(null!=data){
		//	finalData = data.stream().filter(Objects::nonNull).filter(d -> d).collect(Collectors.toList());
		}
		return finalData;
	}
}
