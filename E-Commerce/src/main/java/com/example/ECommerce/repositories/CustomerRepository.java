package com.example.ECommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ECommerce.entities.Customer;

/**
 * Dient dem Zugriff auf die DB für die Tabelle customer
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    
}
