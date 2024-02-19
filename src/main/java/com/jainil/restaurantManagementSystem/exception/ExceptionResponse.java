package com.jainil.restaurantManagementSystem.exception;

import lombok.Data;

@Data
public class ExceptionResponse {

    private Integer status;
    private String message;
    private long timeStamp;

    ExceptionResponse(){

    }
}
