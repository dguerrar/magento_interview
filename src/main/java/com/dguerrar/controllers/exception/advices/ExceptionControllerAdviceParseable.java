package com.dguerrar.controllers.exception.advices;

/**
 * control the selected Exceptions and return the desired response http code 422
 * 
 */
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dguerrar.controllers.exception.ParseableOrderRuntimeException;
import com.dguerrar.generic.GenericModule;

@ControllerAdvice
public class ExceptionControllerAdviceParseable extends GenericModule {

	/**
	 * 
	 */
	private static final long serialVersionUID = -410294039213798375L;

	@ExceptionHandler({ ParseableOrderRuntimeException.class,
			com.fasterxml.jackson.databind.exc.InvalidFormatException.class })
	public ResponseEntity exceptionHandler(Exception ex) {
		log.error("fOUND ExceptionControllerAdviceParseable");
		return new ResponseEntity(ex.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);// 422
	}

	@Override
	protected Class<?> getLogClass() {
		// TODO Auto-generated method stub
		return ExceptionControllerAdviceParseable.class;
	}
}
