package org.yash.deltafuse.dataingestion;

import java.io.PrintWriter;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class DeltaFuseApplication {

	 @Autowired
	 private Environment env;
	 
	public static void main(String[] args) {
		SpringApplication.run(DeltaFuseApplication.class, args);
	}

	@Bean
    public FTPClient sf() throws Exception {
		FTPClient ftp = new FTPClient();
		String host = env.getProperty("app.ftp.host");
		int port = Integer.valueOf(env.getProperty("app.ftp.port"));
		String userName = env.getProperty("app.ftp.user");
		String password = env.getProperty("app.ftp.psw");
		
		ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
		int reply;
		ftp.connect(host, port);
		System.out.println("FTP URL is:" + ftp.getDefaultPort());
		reply = ftp.getReplyCode();
		if (!FTPReply.isPositiveCompletion(reply)) {
			ftp.disconnect();
			throw new Exception("Exception in connecting to FTP Server");
		}
		ftp.login(userName, password);
		ftp.setFileType(FTP.BINARY_FILE_TYPE);
		ftp.enterLocalPassiveMode();
		
        return ftp;
    }
}
