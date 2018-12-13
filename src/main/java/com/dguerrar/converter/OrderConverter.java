package com.dguerrar.converter;

import java.io.IOException;

import com.dguerrar.domain.Order;
import com.dguerrar.generic.GenericModule;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class OrderConverter extends GenericModule {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6862674999072366983L;

	public static String serialize(final Order order) throws JsonProcessingException,IOException   {
		

    	ObjectMapper mapper = new ObjectMapper();
    	String jsonInString = mapper.writeValueAsString(order);
		
		
		return jsonInString;
	}

	public static Order deserialize(final String orderJson)  throws JsonProcessingException,IOException   {
		

    	ObjectMapper mapper = new ObjectMapper();
    	Order order;
		order = mapper.readValue(orderJson, Order.class);

		
		
		return order;
	}
	
	
	@Override
	protected Class<?> getLogClass() {
		return OrderConverter.class;
	}
}
