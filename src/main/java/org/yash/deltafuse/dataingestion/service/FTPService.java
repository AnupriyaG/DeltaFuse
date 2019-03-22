package org.yash.deltafuse.dataingestion.service;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yash.deltafuse.dataingestion.model.FileData;

@Service
public class FTPService {

	@Autowired
	private FileUploadService fileUploadService;
	
	// Creating FTP Client instance
	@Autowired
	FTPClient ftp;

		// Method to upload the File on the FTP Server
		public void uploadFTPFile(String localFileFullName, String fileName, String hostDir) throws Exception {
			try {
				InputStream input = new FileInputStream(new File(localFileFullName));

				this.ftp.storeFile(hostDir + fileName, input);
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		// Download the FTP File from the FTP Server
		public void downloadFTPFile(String source, String destination) {
			try (FileOutputStream fos = new FileOutputStream(destination)) {
				this.ftp.retrieveFile(source, fos);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// list the files in a specified directory on the FTP
		public void listFTPFiles(String directory) throws IOException {
			// lists files and directories in the current working directory
			FTPFile[] files = ftp.listFiles(directory);
			String[] fileNames = ftp.listNames(directory);
			List<String> listName = Arrays.asList(fileNames);
			List<FileData> fileData = null;
			
			List<String> finalNameList = listName.stream().filter(name -> name.endsWith(".xlsx")).collect(Collectors.toList());
			
			for (FTPFile file : files) {
				String details = file.getName();
				System.out.println(details);
				if (finalNameList.contains(details)) {
					System.out.println("Correct Filename");
					InputStream inputstream = ftp.retrieveFileStream(details);
					
					fileData = fileUploadService.readExcelFile(inputstream);
					if(null!=fileData){
						fileUploadService.saveData(fileData);
					}
				}
			}
		}

		// Disconnect the connection to FTP
		public void disconnect() {
			if (this.ftp.isConnected()) {
				try {
					this.ftp.logout();
					this.ftp.disconnect();
				} catch (IOException f) {
					// do nothing as file is already saved to server
					f.printStackTrace();
				}
			}
		}

		// Main method to invoke the above methods
		/*public void readFTPLocationData() {
			try {
				FTPService ftpobj = new FTPService("ftp.dlptest.com", 21, "dlpuser@dlptest.com",
						"VADPRDqid4TaB0r5a2B0n9wLp");

		//		ftpobj.uploadFTPFile("D:\\projectWork\\ftpFile.txt", "ftpFile.txt", "/");

		//		ftpobj.downloadFTPFile("ftpFile.txt", "C:\\ftpFile.txt");
				boolean result = ftpobj.listFTPFiles("/", "ftpFile.txt");

				System.out.println(result);
				System.out.println("=============================================");
				ftpobj.disconnect();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}*/
	
}
