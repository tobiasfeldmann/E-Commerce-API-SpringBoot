package com.example.ECommerce;

import java.util.List;

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

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<CartItem> cart() {
        return cartRepository.findAll();
    }

    @PostMapping ("/create")
    public ResponseEntity<CartItem> createCart(@RequestBody CartRequestItem cartRequestItem) {
        CartItem cartDB;
        
        List<CartItem> items = cartRepository.findByKundenIDAndArtikelID(cartRequestItem.getKundenID(), cartRequestItem.getArtikelID());
        if(items.size() > 0){
            cartDB = this.cartServices.updateCart(items.get(0), cartRequestItem);
        }
        else{
            cartDB = this.cartServices.createCartItem(cartRequestItem);
        }

        return new ResponseEntity<CartItem>(cartDB, HttpStatus.OK);
    }
}
