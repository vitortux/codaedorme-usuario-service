package br.com.codaedorme.usuarioservice.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;

import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
public class BusinessException extends Exception {

	private HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

	public BusinessException(String message) {
		super(message);
		this.httpStatus = HttpStatus.BAD_REQUEST;
	}

	public BusinessException(String message, HttpStatus httpStatus) {
		super(message);
		this.httpStatus = httpStatus;
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
		this.httpStatus = HttpStatus.BAD_REQUEST;
	}

	public BusinessException(String message, Throwable cause, HttpStatus httpStatus) {
		super(message, cause);
		this.httpStatus = httpStatus;
	}
}
