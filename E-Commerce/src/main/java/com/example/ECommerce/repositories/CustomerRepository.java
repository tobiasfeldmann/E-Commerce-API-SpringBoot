package com.example.ECommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ECommerce.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    
}
