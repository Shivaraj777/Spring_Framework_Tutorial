package com.codeslayer.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice  // Controller advice annotation is used to pre/post process REST API requests
public class StudentRestExceptionHandler {

    // add an exception handler to provide Student Error Response if student is not found
    // StudentErrorResponse -> type of the response body
    // StudentNotFoundException -> exception type
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exception){
        // create an error response and set its values
        StudentErrorResponse errorResponse = new StudentErrorResponse();
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimeStamp(System.currentTimeMillis());

        // return the error response entity
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);  // errorResponse -> body, HttpStatus.NOT_FOUND -> status code
    }


    // exception handler for generic exceptions
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exception){
        // create an error response and set its values
        StudentErrorResponse errorResponse = new StudentErrorResponse();
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimeStamp(System.currentTimeMillis());

        // return the error response entity
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
