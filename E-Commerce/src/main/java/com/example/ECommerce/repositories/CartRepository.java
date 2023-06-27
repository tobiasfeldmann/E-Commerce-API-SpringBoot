package com.example.ECommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ECommerce.CartItemId;
import com.example.ECommerce.entities.CartItem;

/**
 * Dient dem Zugriff auf die DB für die Tabelle Cart_Item
 */
public interface CartRepository extends JpaRepository<CartItem, CartItemId> {

}
