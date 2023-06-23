package com.example.ECommerce;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {
    
    private CartRepository cartRepository;

    @Autowired
    private CartServices cartServices;

    public CartController(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @GetMapping("")
    public List<Cart> cart() {
        return cartRepository.findAll();
    }

    @PostMapping (//consumes = {MediaType.APPLICATION_JSON_VALUE},
                    //produces = {MediaType.APPLICATION_JSON_VALUE}
                    "/create")
    public ResponseEntity<Cart> createCart(@RequestBody Cart cart) {
        Cart cartDB = this.cartServices.createCart(cart);

        return new ResponseEntity<Cart>(cart, HttpStatus.OK);
    }
}
