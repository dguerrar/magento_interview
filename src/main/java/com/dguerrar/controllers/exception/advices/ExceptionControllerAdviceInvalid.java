package com.dguerrar.controllers.exception.advices;
/**
 * control the selected Exceptions and return the desired response http code 400
 * 
 */
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dguerrar.controllers.exception.InvalidOrderException;
import com.dguerrar.generic.GenericModule;


@ControllerAdvice
public class ExceptionControllerAdviceInvalid extends GenericModule {


	/**
	 * 
	 */
	private static final long serialVersionUID = -1164764340424003247L;

	@ExceptionHandler(InvalidOrderException.class)
	public ResponseEntity exceptionHandler(InvalidOrderException ex) {
		log.error("fOUND ExceptionControllerAdviceInvalid");
		 return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);//400
	}

	@Override
	protected Class<?> getLogClass() {
		// TODO Auto-generated method stub
		return ExceptionControllerAdviceInvalid.class;
	}
}
