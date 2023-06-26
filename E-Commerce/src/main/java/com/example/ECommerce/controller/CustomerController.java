package com.example.ECommerce.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ECommerce.entities.Customer;
import com.example.ECommerce.repositories.CustomerRepository;

/**
 * Controller für die URL Endung '/customer'
 * Arbeitet mit dem CustomerRepository um in der DB gespeicherte Kunden auszugeben.
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {
    
    private CustomerRepository customerRepository;

    /**
     * Weist der Instanz der Klasse Customer Controller ein übergebenes CustomerRepository zu
     * @param customerRepository
     */
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    /**
     * Get-Request liefert alle in der DB gespeicherten Kunden zurück
     * @return
     */
    @GetMapping("")
    public List<Customer> getAll(){
        return customerRepository.findAll();
    }
}
