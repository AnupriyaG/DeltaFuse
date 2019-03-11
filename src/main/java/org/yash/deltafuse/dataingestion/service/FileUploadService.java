package org.yash.deltafuse.dataingestion.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Service;
import org.yash.deltafuse.dataingestion.model.FileData;

@Service
public interface FileUploadService {

	public void readExcelFile(InputStream inputStream) throws IOException;
}
