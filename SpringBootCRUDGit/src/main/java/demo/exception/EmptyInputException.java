package demo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor 

public class EmptyInputException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String errCode;
	private String errMessage;
	
	
	
}