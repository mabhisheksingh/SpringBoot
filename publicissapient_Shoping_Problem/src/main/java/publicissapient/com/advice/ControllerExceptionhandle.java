package publicissapient.com.advice;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import publicissapient.com.exception.ClotheAllReadyExistException;
import publicissapient.com.exception.EmptyInputException;
import publicissapient.com.exception.NoDataFoundException;

//Global exception handling
@ControllerAdvice
public class ControllerExceptionhandle extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(NoDataFoundException.class)
	public ResponseEntity<String> nodataFound(NoDataFoundException idNotFound){
		System.out.println("Error message : "+idNotFound.getErrorMessage());
		return new ResponseEntity<String>(idNotFound.getErrorMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<Object> emptyInputException(EmptyInputException emptyInput){
		return new ResponseEntity<Object>("Empty Input Entered.",HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ClotheAllReadyExistException.class)
	public ResponseEntity<String> ClotheAllReadyExistException(ClotheAllReadyExistException clotheAllReadyExistException){
		return new ResponseEntity<String>("data All ready exist in DB "+clotheAllReadyExistException.getErrorMessage() ,HttpStatus.CONFLICT);
	}
	
	
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		System.out.println("headers -> "+headers.getOrigin());
		System.out.println("status -> "+status.value());
		System.out.println("ex -> "+ex.getMessage());
		System.out.println("request -> "+request.getContextPath());
	    return new ResponseEntity<Object>( "Wrong Media type selected ",HttpStatus.UNSUPPORTED_MEDIA_TYPE );
	}
	 
	
}
