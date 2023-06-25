package com.example.ECommerce.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ECommerce.CartItemId;
import com.example.ECommerce.contracts.CartItemRequest;
import com.example.ECommerce.contracts.CartItemResponse;
import com.example.ECommerce.entities.CartItem;
import com.example.ECommerce.repositories.ArtikelRepository;
import com.example.ECommerce.repositories.CartRepository;
import com.example.ECommerce.repositories.CustomerRepository;
import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class CartController {
    private CartRepository cartRepository;
    private ArtikelRepository articleRepository;
    private CustomerRepository customerRepository;

    /**
     * Konstruktor für ein neuen CartController mit den nötigen Repositories
     * @param cartRepository
     * @param articleRepository
     * @param customerRepository
     */
    public CartController(CartRepository cartRepository, ArtikelRepository articleRepository, CustomerRepository customerRepository) {
        this.cartRepository = cartRepository;
        this.articleRepository = articleRepository;
        this.customerRepository = customerRepository;
    }

    /**
     * Get Request der URL Endung /cart liefert alle Carts der DB
     * @return
     */
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<CartItem> cart() {
        return cartRepository.findAll();
    }

    /**
     * Methode, die je nach übergebenen Werten und vorhandensein in der DB ein Objekt aktualisiert, erstellt oder löscht
     * @param cartRequestItem, die im Post Request verwendeteten Werte für das Objekt
     * @return ResponseEntity, ein CartItemResponse, das die gesendeten Werte zurückgibt
     */
    @PostMapping
    public ResponseEntity<CartItemResponse> createCart(@RequestBody CartItemRequest cartRequestItem) {
        CartItemId id = new CartItemId(
            articleRepository.getReferenceById(cartRequestItem.articleId),
            customerRepository.getReferenceById(cartRequestItem.customerId)
        );
        Optional<CartItem> item = cartRepository.findById(id);
        if(item.isPresent() && cartRequestItem.amount != 0){
            item.get().setAmount(cartRequestItem.amount);
            CartItem result = cartRepository.save(item.get());
            return new ResponseEntity<CartItemResponse>(new CartItemResponse(result), HttpStatus.OK);
        }
        else if(item.isPresent() && cartRequestItem.amount == 0) {
            cartRepository.delete(item.get());
            return new ResponseEntity<CartItemResponse>(new CartItemResponse(), HttpStatus.ACCEPTED);
        }
        else{
            CartItem newItem = new CartItem();
            newItem.setAmount(cartRequestItem.amount);
            newItem.setArticle(id.getArticle());
            newItem.setCustomer(id.getCustomer());
            CartItem result = cartRepository.save(newItem);
            return new ResponseEntity<CartItemResponse>(new CartItemResponse(result), HttpStatus.CREATED);
        }
    }

}