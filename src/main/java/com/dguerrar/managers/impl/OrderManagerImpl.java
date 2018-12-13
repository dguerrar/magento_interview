package com.dguerrar.managers.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dguerrar.constants.Constants;
import com.dguerrar.controllers.exception.InvalidOrderException;
import com.dguerrar.controllers.exception.ParseableOrderRuntimeException;
import com.dguerrar.converter.OrderConverter;
import com.dguerrar.domain.Notification;
import com.dguerrar.domain.Order;
import com.dguerrar.domain.ProcessingOrder;
import com.dguerrar.domain.base.DataContainer;
import com.dguerrar.generic.GenericModule;
import com.dguerrar.managers.NotificationManager;
import com.dguerrar.managers.OrderManager;
import com.dguerrar.validators.OrderValidator;
import com.fasterxml.jackson.core.JsonProcessingException;


@Service
public class OrderManagerImpl extends GenericModule implements OrderManager {

	/**
	 * 
	 */
	private static final long serialVersionUID = 788056913502531324L;

	@Autowired
	private DataContainer container;
	
	@Autowired
	private OrderValidator validator;
	@Autowired
	NotificationManager notificationManager;
	
	@Override
	public void addOrder(ProcessingOrder order) throws InvalidOrderException, ParseableOrderRuntimeException,JsonProcessingException,IOException {
		

		validator.validate(order);
		
		
		Long storeId=order.getOrder().getStore_id();
		List<Order> orderList;
		List<Long> indexList;
		
		if (container.getRepository().containsKey(storeId)) {
			orderList=container.getRepository().get(storeId);
			indexList=container.getRepositoryOrderNumbers().get(storeId);
		}else {
			orderList= new ArrayList<>();
			indexList=  new ArrayList<>();

		}
		orderList.add(order.getOrder());
		indexList.add(order.getOrder().getId());
		container.getRepository().put(storeId, orderList);
		container.getRepositoryOrderNumbers().put(storeId, indexList);
		

		Notification not= new Notification(Constants.EMAIL_TO,Constants.EMAIL_SUBJECT,OrderConverter.serialize(order.getOrder()));
		notificationManager.sendNotification(not);
	}

	@Override
	protected Class<?> getLogClass() {
		// TODO Auto-generated method stub
		return OrderManagerImpl.class;
	}

}
