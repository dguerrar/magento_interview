package com.dguerrar.controllers.exception.advices;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dguerrar.constants.Constants;
import com.dguerrar.generic.GenericModule;
import com.fasterxml.jackson.core.JsonProcessingException;

public class ExceptionControllerAdvicejsonIO  extends GenericModule {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1164764340424003247L;

	@ExceptionHandler({ JsonProcessingException.class,
		IOException.class })
	public ResponseEntity exceptionHandler(Exception ex) {
		log.error("fOUND ExceptionControllerAdvicejsonIO");
		 return new ResponseEntity(Constants.ERROR_INTERNAL, HttpStatus.INTERNAL_SERVER_ERROR);//500
	}

	@Override
	protected Class<?> getLogClass() {
		// TODO Auto-generated method stub
		return ExceptionControllerAdviceInvalid.class;
	}

}
