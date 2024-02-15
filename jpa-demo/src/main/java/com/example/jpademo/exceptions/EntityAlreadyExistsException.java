package com.example.jpademo.exceptions;

public class EntityAlreadyExistsException extends RuntimeException {


    public EntityAlreadyExistsException(String message)
    {
        super(message);
    }

}
