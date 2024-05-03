package com.codeslayer.springdemo.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.annotation.Annotation;

// Helper class to define business rules for validation applied in CourseCode annotation
public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {
    private String coursePrefix;

    @Override
    public void initialize(CourseCode theCourseCode) {
        // initialize the coursePrefix with CourseCode annotation value
        coursePrefix = theCourseCode.value();
    }

    /*
       theCode -> data passed in form
       theConstraintValidatorContext -> helper class for adding additional error messages
    */
    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {
        boolean result;

        if(theCode != null){
            // check if the entered course code starts with prefix
            result = theCode.startsWith(coursePrefix);
        }else{
            return true;
        }

        return result;
    }
}
