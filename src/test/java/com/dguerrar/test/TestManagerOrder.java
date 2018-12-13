package com.dguerrar.test;



import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.dguerrar.Application;
import com.dguerrar.controllers.exception.InvalidOrderException;
import com.dguerrar.controllers.exception.ParseableOrderRuntimeException;
import com.dguerrar.domain.Line;
import com.dguerrar.domain.Order;
import com.dguerrar.integration.tests.TestSetup;
import com.dguerrar.managers.OrderManager;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
@ContextConfiguration(classes = { Application.class })

public class TestManagerOrder {
	
	
	@Autowired
	private OrderManager orderManager;
	private TestSetup testSetUp;
	

    @Before
    public void before() {
    	testSetUp=new TestSetup();
        

        
    }
    
    
	@Test 
	public void addOrder_200() throws ClientProtocolException, IOException {

		try {
			orderManager.addOrder(testSetUp.ORDER1);
			assertTrue(true);
		} catch (InvalidOrderException | ParseableOrderRuntimeException e) {
			// TODO Auto-generated catch block
			
			assertTrue(false);
			
		}
	}
		/***
		 * testing order with lines not starting at 1
		 * 
		 */
		@Test
		public void addOrder_422_1() {

			try {
				orderManager.addOrder(testSetUp.ORDER2);
				fail();
			} catch (InvalidOrderException | ParseableOrderRuntimeException | IOException e) {
				System.out.println(e.getMessage());
				assertTrue(true);
				
			}
		}
		/**
		 * 
		 * testing order with lines not sequentials
		 * 
		 */
		@Test
		public void addOrder_422_2() {

			try {
				orderManager.addOrder(testSetUp.ORDER3);
				fail();
			} catch (InvalidOrderException | ParseableOrderRuntimeException | IOException e) {
				System.out.println(e.getMessage());
				assertTrue(true);
				
			}
		}	
		/**
		 * 
		 * testing empty lines on an order
		 */
		@Test
		public void addOrder_422_3() {

			try {
				orderManager.addOrder(testSetUp.ORDER4);
				fail();
			} catch (InvalidOrderException | ParseableOrderRuntimeException | IOException e) {
				System.out.println(e.getMessage());
				assertTrue(true);
				
			}
		}
		
		/**
		 * 
		 * testing empty lines on an order
		 */
		@Test
		public void addOrder_400() {

			try {
				orderManager.addOrder(testSetUp.ORDER1);
				orderManager.addOrder(testSetUp.ORDER11);
				fail();
			} catch (InvalidOrderException | ParseableOrderRuntimeException | IOException e) {
				System.out.println(e.getMessage());
				assertTrue(true);
				
			}
		}
		
		
}
