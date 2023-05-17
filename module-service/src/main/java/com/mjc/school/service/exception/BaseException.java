package com.mjc.school.service.exception;

public abstract class BaseException extends RuntimeException {

    public final int status;
    public final String message;

    public BaseException(ErrorCode errorCode, String message) {
        super(message);
        status = errorCode.getCode();
        this.message = message;
    }
}
