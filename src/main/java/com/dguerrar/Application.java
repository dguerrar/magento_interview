package com.dguerrar;


import java.text.ParseException;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dguerrar.quarts.jobs.EmailJob;


@SpringBootApplication
public class Application {

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
        
        
        JobDetail jobWorkDone = new JobDetail("emailNotificator", "emailNotificator", EmailJob.class);
		CronTrigger trigger = new CronTrigger("emailNotificator", "emailNotificator");
		try {
			trigger.setCronExpression("0 0/5 * * * ?");
			Scheduler sched = StdSchedulerFactory.getDefaultScheduler();
			sched.scheduleJob(jobWorkDone, trigger);

		} catch (ParseException | SchedulerException e) {
			e.printStackTrace();
		} 

    }

}
