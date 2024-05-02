package com.codeslayer.springdemo.mvc.controller;

import com.codeslayer.springdemo.mvc.model.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    /*
       method to remove leading/trailing white spaces from all strings
       @InitBinder annotation is used to pre-process a method before initiating the controller method.
    */
    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor); // bind the String class data to use StringTrimmerEditor
    }


    // controller method to display customer form
    @GetMapping("/showForm")
    public String showCustomerForm(Model theModel){
        // create the customer object and add it to the spring MVC model to bind form data
        Customer theCustomer = new Customer();
        theModel.addAttribute("customer", theCustomer);
        return "customer-form";
    }


    // controller method to process customer form data after submit
    // @Valid annotation is used to perform validation on object passed in request
    // theBindingResult objects contains the results of validation
    @PostMapping("/processCustomerForm")
    public String processCustomerForm(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult theBindingResult){
        // check LastName
        System.out.println("Last Name: |" + theCustomer.getLastName() + "|");

        // check BindingResults object to find out the validation errors
        System.out.println("Binding result object: " + theBindingResult);

        if(theBindingResult.hasErrors()){
            return "customer-form";
        }

        return "customer-confirmation";
    }
}
