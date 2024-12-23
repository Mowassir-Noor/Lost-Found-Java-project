package com.gazi.lostFound.exceptions;

public class InvalidCredentials extends RuntimeException {
//    custom exception inherited from runtimeexception
    public InvalidCredentials(String message) {

        super(message);
    }
}
