package com.codeslayer.springdemo.mvc.controller;

import com.codeslayer.springdemo.mvc.model.Customer;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customers")
public class CustomerController {

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
        if(theBindingResult.hasErrors()){
            return "customer-form";
        }

        return "customer-confirmation";
    }
}
