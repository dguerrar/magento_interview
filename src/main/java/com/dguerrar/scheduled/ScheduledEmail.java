package com.dguerrar.scheduled;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.dguerrar.domain.Notification;
import com.dguerrar.domain.base.DataContainer;
import com.dguerrar.generic.GenericModule;

@Component
public class ScheduledEmail extends GenericModule {

	/**
	 * 
	 */
	private static final long serialVersionUID = 816093237848987628L;

	
	@Autowired
	private DataContainer container;
	
	@Override
	protected Class<?> getLogClass() {
		return ScheduledEmail.class;
	}
	
	
	@Scheduled(cron = "*/10 * * * * *")
	public void processNotifications() {
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
