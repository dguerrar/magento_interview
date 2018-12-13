package com.dguerrar.quarts.jobs;

import java.util.Calendar;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.dguerrar.domain.Notification;
import com.dguerrar.domain.base.DataContainer;

public class EmailJob extends QuartzJobBean {

	protected Logger log = LoggerFactory.getLogger(EmailJob.class);
	
	@Autowired
	private DataContainer container;
	
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		
		long time= Calendar.getInstance().getTimeInMillis();
		//in order to make a FAKE error sending email,
		if (time %2==0) {
			log.error("Cannot send email. Server down");
		}else {
			log.info("Starting sending emails");
			
			//here it must control if EMAIL server is UP
			if (Boolean.FALSE==container.getNotificationQueue().isEmpty()) {
				for (Notification not; (not = container.getNotificationQueue().poll()) != null; ) {
					sendEmail(not.getTo(), not.getSubject(), not.getContent());
				}
			}
			
		}
		
		
		
	}
	
	
	private void sendEmail(String to, String subject, String content) {
		log.info("sending email to: {} , {}, {}", to, subject,content);
		
	}

}
