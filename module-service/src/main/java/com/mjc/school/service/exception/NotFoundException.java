package com.mjc.school.service.exception;

public class NotFoundException extends BaseException {

    public NotFoundException(String message) {
        super(ErrorCode.NOT_FOUND, message);
    }
}
