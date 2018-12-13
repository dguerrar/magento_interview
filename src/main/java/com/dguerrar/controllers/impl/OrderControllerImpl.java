package com.dguerrar.controllers.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dguerrar.controllers.OrderController;
import com.dguerrar.controllers.exception.InvalidOrderException;
import com.dguerrar.controllers.exception.OrderRuntimeException;
import com.dguerrar.controllers.exception.ParseableOrderRuntimeException;
import com.dguerrar.domain.Order;
import com.dguerrar.domain.ProcessingOrder;
import com.dguerrar.generic.GenericModule;
import com.dguerrar.managers.OrderManager;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.dguerrar.constants.Constants;

@RestController
public class OrderControllerImpl extends GenericModule implements OrderController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7751773573540968042L;

	
	@Autowired
	private OrderManager orderManager;
	


	@Override
	@PostMapping(Constants.ENDPOINT_ORDERS)
	public ResponseEntity addOrder(@RequestBody ProcessingOrder order)
			throws OrderRuntimeException, ParseableOrderRuntimeException, InvalidOrderException, JsonProcessingException, IOException{
		log.debug("-->addOrder (order {})", order);
		// TODO Auto-generated method stub
		orderManager.addOrder(order);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(Constants.INFO_SUCESS);
	}

	
	@Override
	protected Class<?> getLogClass() {
		// TODO Auto-generated method stub
		return OrderControllerImpl.class;
	}
	
	public OrderManager getOrderManager() {
		return orderManager;
	}

	public void setOrderManager(OrderManager orderManager) {
		this.orderManager = orderManager;
	}
	
	

}
