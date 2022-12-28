package com.example.sonagi.exception;

public class BusinessException extends RuntimeException {
	public static final BusinessException USER_NOT_FOUND_BY_USERNAME = new BusinessException(ErrorCode.USER_NOT_FOUND, "가입 되지 않은 아이디입니다.");
	public static final BusinessException USER_NOT_FOUND_BY_PASSWORD = new BusinessException(ErrorCode.USER_NOT_FOUND, "비밀번호가 올바르지 않습니다.");
	public static final BusinessException USERNAME_ALREADY_EXIST = new BusinessException(ErrorCode.CAN_NOT_CREATE_USER, "이미 존재하는 아이디입니다.");
	public static final BusinessException NOT_FOUND_FAMILY_CODE = new BusinessException(ErrorCode.INVALID_INPUT_VALUE, "가족 코드가 올바르지 않습니다.");
	public static final BusinessException INVALID_TOKEN = new BusinessException(ErrorCode.INVALID_INPUT_VALUE, "토큰이 올바르지 않습니다.");
	public static final BusinessException FAMILY_NOT_FOUND = new BusinessException(ErrorCode.INVALID_INPUT_VALUE, "가족 id가 올바르지 않습니다");

	private ErrorCode errorCode;
	private String message;

	public BusinessException(ErrorCode errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}
}
