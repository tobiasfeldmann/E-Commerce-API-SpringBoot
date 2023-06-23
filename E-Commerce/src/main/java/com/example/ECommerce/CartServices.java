package com.example.ECommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServices{

    @Autowired
    private CartRepository cartRepository;

    public CartItem createCartItem(CartRequestItem cartRequestItem) {
        CartItem cartDB = new CartItem(cartRequestItem);
        cartRepository.save(cartDB);
        return cartDB;
    }

    public CartItem updateCart(CartItem cartItem, CartRequestItem cartRequestItem) {
        cartItem.setAnzahl(cartRequestItem.getAnzahl());
        this.cartRepository.save(cartItem);
        return cartItem;            
    }
    
}
