package publicissapient.com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ClotheAllReadyExistException  extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private String errorMessage;
	private HttpStatus errorCode;

}
