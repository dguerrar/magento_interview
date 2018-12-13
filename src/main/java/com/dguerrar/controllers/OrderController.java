package com.dguerrar.controllers;

import java.io.IOException;

import org.springframework.http.ResponseEntity;

import com.dguerrar.controllers.exception.InvalidOrderException;
import com.dguerrar.controllers.exception.OrderRuntimeException;
import com.dguerrar.controllers.exception.ParseableOrderRuntimeException;
import com.dguerrar.domain.Order;
import com.dguerrar.domain.ProcessingOrder;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface OrderController {
	
	/**
	 * controller restful for POST a new order
	 * 
	 * @param order 
	 * @return  200 if OK
	 * @throws OrderRuntimeException  //return  HttpStatus.INTERNAL_SERVER_ERROR);//500  .--> exception somewhere in the code
	 * @throws ParseableOrderRuntimeException  //return HttpStatus.UNPROCESSABLE_ENTITY 422 --> data that is not correct but json correct
	 * @throws InvalidOrderException  //return HttpStatus.BAD_REQUEST);//400  --> error  
	 */
	public ResponseEntity addOrder(ProcessingOrder order) throws OrderRuntimeException,
			ParseableOrderRuntimeException, InvalidOrderException, JsonProcessingException, IOException;
	

}
