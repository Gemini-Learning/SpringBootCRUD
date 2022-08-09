package demo.advice;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import demo.controller.EmployeeController;
import demo.exception.EmptyInputException;



@ControllerAdvice
public class EmployeeControllerAdvice {

	Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<String> handleEmptyInput(EmptyInputException emptyInputExcption){
		 logger.info("Input fields are empty, please recheck");
		 logger.error("Input fields are empty, please recheck");
		return new ResponseEntity<String>("Input fields are empty, please recheck",HttpStatus.BAD_REQUEST);
	};
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElement(NoSuchElementException excption){
		logger.info("Input fields are empty, please recheck");
		logger.error("Input fields are empty, please recheck");
		return new ResponseEntity<String>("The element does not exist, please recheck",HttpStatus.NOT_FOUND);
	};
	

	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<String> handleEmptyResultData(EmptyResultDataAccessException excption){
		logger.info("The requested employee doesnot exist , please recheck empId");
		logger.error("The requested employee doesnot exist , please recheck empId");
		return new ResponseEntity<String>("The element does not exist, please recheck",HttpStatus.NOT_FOUND);
	};
	
	
	
	
}