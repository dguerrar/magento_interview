package com.dguerrar.managers;

import java.io.IOException;

import com.dguerrar.controllers.exception.InvalidOrderException;
import com.dguerrar.controllers.exception.ParseableOrderRuntimeException;
import com.dguerrar.domain.Order;
import com.dguerrar.domain.ProcessingOrder;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface OrderManager {

	
	
	/**
	 * update the statitistic given a new transaction
	 * 
	 * @param transaction
	 */
	public void addOrder(ProcessingOrder order)  throws InvalidOrderException, ParseableOrderRuntimeException,JsonProcessingException,IOException ;
	
}
