package publicissapient.com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Component
public class NoDataFoundException extends RuntimeException {

	/**
	 * Custom Exception creation it is called when Id not found in DB
	 */
	private static final long serialVersionUID = 1L;
	private String errorMessage;
	private HttpStatus errorCode;
	

	
}
