package com.vzcodingassignment.exception;


public class UserBadRequestException extends RuntimeException{
    public UserBadRequestException() {
    }

    public UserBadRequestException(final String message) {
        super(message);
    }

    public UserBadRequestException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
