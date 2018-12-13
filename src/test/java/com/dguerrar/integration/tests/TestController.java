package com.dguerrar.integration.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.context.support.GenericWebApplicationContext;

import com.dguerrar.Application;
import com.dguerrar.domain.Order;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration

public class TestController {
    private static final MediaType CONTENT_TYPE_JSON = MediaType.APPLICATION_JSON_UTF8;
	private static final String URL="http://localhost:8080/orders/";
	private static  Order ORDER;
	
    @Autowired
    private GenericWebApplicationContext webApplicationContext;

    private TestSetup testSetUp;
    private MockMvc mockMvc;

    @Before
    public void getContext() {
        mockMvc = webAppContextSetup(webApplicationContext).build();
        assertNotNull(mockMvc);
        
        testSetUp=new TestSetup();
        
    }
    
    
    
    @Test
    public void add_Response_400() {
    //parser error. 
        try {

        	
            ResultActions resultActions = mockMvc.perform(post(URL)
                    .content(testSetUp.ORDER5_STR)
                    .contentType(CONTENT_TYPE_JSON));
            MockHttpServletResponse mockResponse = resultActions.andReturn()
                    .getResponse();

            assertTrue( String.valueOf(mockResponse.getStatus()).equalsIgnoreCase(HttpStatus.BAD_REQUEST.toString()));
        } catch (Exception ex) {
        	fail();
        }
        
    }
    
    
    @Test
    public void add_Response_422_1() {
    //parser error. Json incorrect format

    	
        try {
        	ObjectMapper mapper = new ObjectMapper();
        	String jsonInString = mapper.writeValueAsString(testSetUp.ORDER2);
        	
            ResultActions resultActions = mockMvc.perform(post(URL)
                    .content(jsonInString)
                    .contentType(CONTENT_TYPE_JSON));
            MockHttpServletResponse mockResponse = resultActions.andReturn()
                    .getResponse();

            assertTrue( String.valueOf(mockResponse.getStatus()).equalsIgnoreCase(HttpStatus.UNPROCESSABLE_ENTITY.toString()));
        } catch (Exception ex) {
        	fail();
        }
        
        
    }
    
    
    @Test
    public void add_Response_422_2() {
    //parser error. Json incorrect format

    	
        try {
        	ObjectMapper mapper = new ObjectMapper();
        	String jsonInString = mapper.writeValueAsString(testSetUp.ORDER3);
        	
            ResultActions resultActions = mockMvc.perform(post(URL)
                    .content(jsonInString)
                    .contentType(CONTENT_TYPE_JSON));
            MockHttpServletResponse mockResponse = resultActions.andReturn()
                    .getResponse();

            assertTrue( String.valueOf(mockResponse.getStatus()).equalsIgnoreCase(HttpStatus.UNPROCESSABLE_ENTITY.toString()));
        } catch (Exception ex) {
        	fail();
        }
        
        
    }
    
    
    @Test
    public void add_Response_422_3() {
    //parser error. Json incorrect format

    	
        try {
        	ObjectMapper mapper = new ObjectMapper();
        	String jsonInString = mapper.writeValueAsString(testSetUp.ORDER4);
        	
            ResultActions resultActions = mockMvc.perform(post(URL)
                    .content(jsonInString)
                    .contentType(CONTENT_TYPE_JSON));
            MockHttpServletResponse mockResponse = resultActions.andReturn()
                    .getResponse();

            assertTrue( String.valueOf(mockResponse.getStatus()).equalsIgnoreCase(HttpStatus.UNPROCESSABLE_ENTITY.toString()));
        } catch (Exception ex) {
        	fail();
        }
        
        
    }
    
    
    
    
    @Test
    public void add_Response_200() {
    //save OK

    	
        try {

        	
        	
        	ObjectMapper mapper = new ObjectMapper();
        	String jsonInString = mapper.writeValueAsString(testSetUp.ORDER1);
        	
            ResultActions resultActions = mockMvc.perform(post(URL)
                    .content(jsonInString)
                    .contentType(CONTENT_TYPE_JSON));
            MockHttpServletResponse mockResponse = resultActions.andReturn()
                    .getResponse();

            assertTrue( String.valueOf(mockResponse.getStatus()).equalsIgnoreCase(HttpStatus.OK.toString()));
        } catch (Exception ex) {
           fail();
        }
        
        
    }
}
