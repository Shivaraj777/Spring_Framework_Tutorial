package com.codeslayer.springdemo.mvc.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Customer {
    private String firstName;

    // perform validation on lastName attribute based on applied annotation, if not satisfied throw validation exception
    @NotNull(message = "is required")  // @NotNull() -> attribute value should not be null
    @Size(min = 1, message = "is required")  // min size of attribute value should be 1
    private String lastName;

    public Customer() { }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
