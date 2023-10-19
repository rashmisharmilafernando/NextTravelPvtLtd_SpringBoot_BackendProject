package com.rashi.vehicleserver.exception;

public class InvalidException extends RuntimeException{
    public InvalidException(String message){
        super(message);
    }
}
