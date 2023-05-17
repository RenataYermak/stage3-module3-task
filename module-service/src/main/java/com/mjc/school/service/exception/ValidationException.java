package com.mjc.school.service.exception;

public class ValidationException extends BaseException {

    public ValidationException(String message) {
        super(ErrorCode.BAD_REQUEST, message);
    }
}
