package org.yash.deltafuse.dataingestion.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.yash.deltafuse.dataingestion.model.FileData;

@Service
public interface DataDiscoveryService {

	public List<FileData> getPriceDiscovery();

	public List<FileData> getSalesDiscovery();
}
