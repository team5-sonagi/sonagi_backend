package com.example.sonagi.common;

import com.example.sonagi.exception.BusinessException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice(annotations = RestController.class)
public class ResponseEntityExceptionHandler {
	@ExceptionHandler(value = {BusinessException.class})
	protected ResponseEntity<ErrorResponse<Object>> badRequestError(BusinessException e) {
		return ResponseEntity
			.status(e.getErrorCode().getHttpStatus())
			.body(ErrorResponse.error(e.getErrorCode(), e.getMessage()));
	}
}
