package com.gazi.lostFound.exceptions;

public class UserAlreadyExistsException extends RuntimeException{
//custom exception
    public UserAlreadyExistsException(String message){
        super(message);
    }
}
