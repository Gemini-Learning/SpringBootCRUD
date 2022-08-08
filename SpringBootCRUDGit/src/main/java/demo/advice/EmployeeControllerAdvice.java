package demo.advice;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import demo.exception.EmptyInputException;



@ControllerAdvice
public class EmployeeControllerAdvice {

	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<String> handleEmptyInput(EmptyInputException emptyInputExcption){
		
		return new ResponseEntity<String>("Input fields are empty, please recheck",HttpStatus.BAD_REQUEST);
		
	};
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElement(EmptyInputException emptyInputExcption){
		
		return new ResponseEntity<String>("The element does not exist, please recheck",HttpStatus.BAD_REQUEST);
		
	};
	
	
}