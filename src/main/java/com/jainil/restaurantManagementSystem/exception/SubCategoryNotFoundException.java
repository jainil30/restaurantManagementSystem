package com.jainil.restaurantManagementSystem.exception;

public class SubCategoryNotFoundException extends RuntimeException{
    public SubCategoryNotFoundException() {
    }

    public SubCategoryNotFoundException(String message) {
        super(message);
    }

    public SubCategoryNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public SubCategoryNotFoundException(Throwable cause) {
        super(cause);
    }

    public SubCategoryNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
