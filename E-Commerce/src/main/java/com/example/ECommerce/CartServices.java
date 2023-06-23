package com.example.ECommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServices{

    @Autowired
    private CartRepository cartRepository;

    public Cart createCart(Cart cart) {
        Cart cartDB = this.cartRepository.save(cart);

        return cartDB;
    }
    
}
