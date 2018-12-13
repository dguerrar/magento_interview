package com.dguerrar.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.dguerrar.Application;
import com.dguerrar.constants.Constants;
import com.dguerrar.converter.OrderConverter;
import com.dguerrar.domain.Notification;
import com.dguerrar.integration.tests.TestSetup;
import com.dguerrar.managers.NotificationManager;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
@ContextConfiguration(classes = { Application.class })
public class TestManagerNotification {

	@Autowired
	NotificationManager notificationManager;
	private TestSetup testSetUp;
	
	
    @Before
    public void before() {
    	testSetUp=new TestSetup();
    }
	@Test
	public void testNotitiication() {
		
		
		try {
			Notification not= new Notification(Constants.EMAIL_TO,Constants.EMAIL_SUBJECT,OrderConverter.serialize(testSetUp.OORDER1));
			notificationManager.sendNotification(not);
			assertTrue(true);
		} catch (IOException e) {
			fail();
		}
	}
	
	
	
	
}
