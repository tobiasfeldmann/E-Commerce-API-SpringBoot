package com.example.ECommerce.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ECommerce.entities.Customer;
import com.example.ECommerce.repositories.CustomerRepository;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    
    private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("")
    public List<Customer> getAll(){
        return customerRepository.findAll();
    }
}
