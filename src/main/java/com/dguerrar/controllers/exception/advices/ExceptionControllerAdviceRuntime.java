package com.dguerrar.controllers.exception.advices;

/**
 * control the selected Exceptions and return the desired response http code 500
 * 
 */
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dguerrar.controllers.exception.OrderRuntimeException;
import com.dguerrar.generic.GenericModule;

@ControllerAdvice
public class ExceptionControllerAdviceRuntime extends GenericModule {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4684103515995236919L;

	@ExceptionHandler({OrderRuntimeException.class,NullPointerException.class})
	public ResponseEntity exceptionHandler(OrderRuntimeException ex) {
		log.error("fOUND ExceptionControllerAdviceRuntime");
		 return new ResponseEntity(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);//500
	}

	@Override
	protected Class<?> getLogClass() {
		// TODO Auto-generated method stub
		return ExceptionControllerAdviceRuntime.class;
	}
}
