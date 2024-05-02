package com.codeslayer.springdemo.mvc.model;

import jakarta.validation.constraints.*;

public class Customer {
    private String firstName;

    // perform validation on lastName attribute based on applied annotation, if not satisfied throw validation exception
    @NotNull(message = "is required")  // @NotNull() -> attribute value should not be null
    @Size(min = 1, message = "is required")  // min size of attribute value should be 1
    private String lastName;

    // @Max and @Min annotations are used to set the min and max value for the attribute
    // to make Integer fields required used Integer class instead of int data type to handle edge case of converting string to int
    @NotNull(message = "is required")
    @Min(value = 0, message = "value must be greater than or equal to 0")
    @Max(value = 10, message = "value must be less than or equal to 10")
    private Integer freePasses;

    // @Pattern annotation is used to create regular expressions - the value in attribute must match the exprssion
    @Pattern(regexp = "^[a-zA-Z0-9]{6}", message = "only 6 chars/digits can be entered")
    private String postalCode;

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

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
