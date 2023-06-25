package com.example.ECommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ECommerce.CartItemId;
import com.example.ECommerce.entities.CartItem;

public interface CartRepository extends JpaRepository<CartItem, CartItemId> {

}
