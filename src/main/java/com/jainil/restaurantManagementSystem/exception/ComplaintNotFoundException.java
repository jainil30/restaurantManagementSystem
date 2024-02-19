package com.jainil.restaurantManagementSystem.exception;

public class ComplaintNotFoundException extends RuntimeException{
    public ComplaintNotFoundException() {
    }

    public ComplaintNotFoundException(String message) {
        super(message);
    }

    public ComplaintNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ComplaintNotFoundException(Throwable cause) {
        super(cause);
    }

    public ComplaintNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
