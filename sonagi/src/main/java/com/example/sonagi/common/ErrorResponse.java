package com.example.sonagi.common;

import com.example.sonagi.exception.ErrorCode;
import lombok.Builder;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@JsonInclude(Include.NON_NULL)
public class ErrorResponse<T> {
	private HttpStatus errorStatusCode;
	private String errorTitle;
	private String detail;

	// 상세 오류 메시지를 포함
	public static <T> ErrorResponse<T> error(ErrorCode errorCode, String errorMessage) {
		return new ErrorResponse<>(errorCode.getHttpStatus(), errorCode.getDescription(), errorMessage);
	}
}
