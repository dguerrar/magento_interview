package com.dguerrar.validators.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dguerrar.constants.Constants;
import com.dguerrar.controllers.exception.InvalidOrderException;
import com.dguerrar.controllers.exception.ParseableOrderRuntimeException;
import com.dguerrar.domain.Line;
import com.dguerrar.domain.Order;
import com.dguerrar.domain.ProcessingOrder;
import com.dguerrar.domain.base.DataContainer;
import com.dguerrar.generic.GenericModule;
import com.dguerrar.validators.OrderValidator;


@Component
public class OrderValidatorImpl extends GenericModule implements OrderValidator{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2648130821574786963L;
	
	@Autowired
	private DataContainer container;

	@Override
	public void validate(ProcessingOrder porder) throws ParseableOrderRuntimeException,InvalidOrderException {
		log.debug("-->validate (order {})",porder);
		long start=0l;
		
		if (porder==null || porder.getOrder()==null || porder.getOrder().getId() ==null || porder.getOrder().getStore_id()==null) {
			throw new InvalidOrderException(Constants.ERROR_FORMAT_INCORRECT);
		}
		Order order= porder.getOrder();
		
		if (order.getLines().isEmpty()) {
			throw new ParseableOrderRuntimeException(Constants.ERROR_EMPTY_LINES) ;  //lines are not sequential
		}
		for(Line l:order.getLines()) {
			if (start!=0) {
				if ((start +1)!= l.getLine_number()) {
					throw new ParseableOrderRuntimeException(Constants.ERROR_NON_SEQUENTIAL_LINES) ;  //lines are not sequential
				}
				start++;
				}
			else { //start=00
				start=l.getLine_number();
				if (start!=1){
					throw new ParseableOrderRuntimeException(Constants.ERROR_NUMBER_LINES);//lines does not start at 1
				}
			}
		}
		
		//test the previous existence of the order in the table of current shop
		
		if (container.getRepositoryOrderNumbers().containsKey(order.getStore_id())) {
			List<Long> idStoreList=container.getRepositoryOrderNumbers().get(order.getStore_id());
			
			if (idStoreList.contains(order.getId())) {
				throw new InvalidOrderException(Constants.ERROR_EXISTING_ORDER);
			}
			
		}
		
		
		log.debug("<--validate (order)");

		
		
	}

	@Override
	protected Class<?> getLogClass() {
		// TODO Auto-generated method stub
		return OrderValidatorImpl.class;
	}

}
