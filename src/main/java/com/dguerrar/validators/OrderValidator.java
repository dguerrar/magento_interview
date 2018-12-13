package com.dguerrar.validators;

import com.dguerrar.controllers.exception.InvalidOrderException;
import com.dguerrar.controllers.exception.ParseableOrderRuntimeException;
import com.dguerrar.domain.Order;
import com.dguerrar.domain.ProcessingOrder;

public interface OrderValidator {
	
	public void validate(ProcessingOrder porder) throws ParseableOrderRuntimeException,InvalidOrderException;


}
