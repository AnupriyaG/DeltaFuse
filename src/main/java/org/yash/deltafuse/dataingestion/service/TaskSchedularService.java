package org.yash.deltafuse.dataingestion.service;

import java.util.Map;
import java.util.concurrent.ScheduledFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;
import org.yash.deltafuse.dataingestion.constant.ScheduleConstant;

@Service("taskSchedularService")
public class TaskSchedularService { 

	@Autowired
	private FTPService ftpService;
	
	
	@SuppressWarnings("rawtypes")
	ScheduledFuture scheduledFuture;

	ThreadPoolTaskScheduler taskScheduler ;
	
	Runnable exampleRunnable = new Runnable(){
	    @Override
	    public void run() {
	        System.out.println("Works");
	        try {
				//ftpService.uploadFTPFile("D:\\Project\\TestFile.txt", "TestFile.txt", "/");
	        	//ftpService.downloadFTPFile("ftpFile.txt", "C:\\ftpFile.txt");
				ftpService.listFTPFiles("/");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	};
	
	public static String  getCronExp(final Map<String, String> inputs) {

	    System.out.println(">>  getCronExp");

	    String exp = "";

	    final String type = (String) inputs.get(ScheduleConstant.SCHEDULER_TYPE);
	    final String time = (String) inputs.get(ScheduleConstant.TIME);
	    final String[] split = time.split(ScheduleConstant.COLON);
	    String hour = split[0];
	    String min = split[1];

	    if ("0".equalsIgnoreCase(min)) {
	        min = ScheduleConstant.ZERO;
	    }
	    if ("0".equalsIgnoreCase(hour)) {
	        hour = ScheduleConstant.ZERO;
	    }
	    if ("daily".equalsIgnoreCase(type)) {

	        exp = ScheduleConstant.ZERO + ScheduleConstant.WHITE_SPACE + min + ScheduleConstant.WHITE_SPACE + hour + ScheduleConstant.WHITE_SPACE + ScheduleConstant.ASTERISK + ScheduleConstant.WHITE_SPACE + ScheduleConstant.ASTERISK
	                + ScheduleConstant.WHITE_SPACE + "?";

	    } else if ("monthly".equalsIgnoreCase(type)) {
	        final String date = (String) inputs.get(ScheduleConstant.START_DATE);
	        exp = ScheduleConstant.ZERO + ScheduleConstant.WHITE_SPACE + min + ScheduleConstant.WHITE_SPACE + hour + ScheduleConstant.WHITE_SPACE + date + ScheduleConstant.WHITE_SPACE + ScheduleConstant.ASTERISK + ScheduleConstant.WHITE_SPACE
	                + "?";

	    } else if ("weekly".equalsIgnoreCase(type)) {

	        final String dayOfWeek = (String) inputs.get(ScheduleConstant.DAY_OF_WEEK);

	        exp = ScheduleConstant.ZERO + ScheduleConstant.WHITE_SPACE + min + ScheduleConstant.WHITE_SPACE + hour + ScheduleConstant.WHITE_SPACE + "?" + ScheduleConstant.WHITE_SPACE + ScheduleConstant.ASTERISK + ScheduleConstant.WHITE_SPACE
	                + dayOfWeek;
	    }

	    System.out.println("Latest cron  expression scheduler " + exp);
	    System.out.println("<<  getCronExp");
	    return exp;
	}
	
	//this method will kill previous scheduler if exists and will create a new scheduler with given cron expression
	public  void reSchedule(String cronExpressionStr){
	 if(taskScheduler== null){
	     taskScheduler = new ThreadPoolTaskScheduler();

	     taskScheduler.setPoolSize(10);
	     taskScheduler.setThreadNamePrefix("my-scheduled-task-pool-");
	     taskScheduler.initialize();
	    }
	     if (this.scheduledFuture != null) {
	    	 scheduledFuture.cancel(true);
	    }
	 this.scheduledFuture = this.taskScheduler.schedule(exampleRunnable, new CronTrigger(cronExpressionStr));
	}
	
	public void initializeScheduler(Map<String, String> inputs) {
		this.reSchedule(getCronExp(inputs));
	}
	
}
