package com.example.jpademo.beans;

import com.example.jpademo.exceptions.EntityAlreadyExistsException;
import com.example.jpademo.exceptions.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException entityNotFoundException)
    {
        Map<String,Object> response = new HashMap<>();
        response.put("message",entityNotFoundException.getMessage());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler({EntityAlreadyExistsException.class})
    public ResponseEntity<Object> handleEntityAlreadyExist(EntityAlreadyExistsException entityAlreadyExistsException)
    {
        Map<String,Object> response = new HashMap<>();
        response.put("message",entityAlreadyExistsException.getMessage());

        return new ResponseEntity<>(response, HttpStatus.CONFLICT);

    }



}
