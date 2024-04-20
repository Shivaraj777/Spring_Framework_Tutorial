package com.codeslayer.demo.rest;

public class StudentNotFoundException extends RuntimeException{

    public StudentNotFoundException() {
    }

    public StudentNotFoundException(String message) {
        super(message); // extend super class constructor
    }

    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentNotFoundException(Throwable cause) {
        super(cause);
    }
}
