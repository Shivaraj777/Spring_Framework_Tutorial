package com.codeslayer.springdemo.mvc.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
   define custom annotation interface called CourseCode...
   @interface -> special annotation to create a special interface
   @Target annotation is used to specify where to apply the custom annotation -> in this case, method and field
   @Retention annotation specifies how long will the annotation be used -> here, we are retaining it in .class file(byte code) after compilation to use during runtime.
*/
@Constraint(validatedBy = CourseCodeConstraintValidator.class)  // Helper class that contains business rules for validation.
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
    /* define the attributes to be passed in annotation */

    // define default course code
    public String value() default "LUV";

    // define default error message
    public String message() default  "course code must start with LUV";

    // define default groups(to group validation rules)
    public Class<?>[] groups() default {};

    // define default payloads(to provide additional data about error)
    public Class<? extends Payload>[] payload() default {};

}
