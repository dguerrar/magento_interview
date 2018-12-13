package com.dguerrar.controllers.exception.advices;
/**
 * control the selected Exceptions and return the desired response http code 400
 * 
 */
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dguerrar.constants.Constants;
import com.dguerrar.controllers.exception.OrderBindingException;
import com.dguerrar.generic.GenericModule;


@ControllerAdvice
public class ExceptionControllerAdviceBinding extends GenericModule {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1772395021354429794L;

	@ExceptionHandler(	{OrderBindingException.class,org.springframework.http.converter.HttpMessageNotReadableException.class})
	public ResponseEntity exceptionHandler(Exception ex) {
		log.error("fOUND ExceptionControllerAdviceBinding");
		return new ResponseEntity(Constants.ERROR_BAD_FORMAT, HttpStatus.BAD_REQUEST);//400
		
	}

	@Override
	protected Class<?> getLogClass() {
		// TODO Auto-generated method stub
		return ExceptionControllerAdviceBinding.class;
	}
	
	 
}
