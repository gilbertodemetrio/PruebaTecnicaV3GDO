package com.mx.fonyou.test.rest.enums;

import org.springframework.http.HttpStatus;

import lombok.Getter;

public enum ErrorCode {
	
	INVALID_DATA(1, HttpStatus.CONFLICT, "Datos ingresados incorrectos");

	@Getter
	private Integer code;
	@Getter
	private String message;
	@Getter
	private HttpStatus httpStatus;
	
	private ErrorCode(Integer code, HttpStatus httpStatus, String message) {
		this.code = code;
		this.message = message;
		this.httpStatus = httpStatus;
	}
	
	
}
