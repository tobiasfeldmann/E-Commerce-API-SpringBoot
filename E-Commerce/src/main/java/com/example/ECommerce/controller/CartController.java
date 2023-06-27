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
import com.example.ECommerce.repositories.ArticleRepository;
import com.example.ECommerce.repositories.CartRepository;
import com.example.ECommerce.repositories.CustomerRepository;
import java.util.Optional;

/**
 * Controller für Requests der URL Endung '/cart'
 * Verarbeitet CartItemResponse und liefert als Antwort auf einen Request ein CartItemResponse
 */
@RestController
@RequestMapping("/cart")
public class CartController {
    
    private CartRepository cartRepository;
    private ArticleRepository articleRepository;
    private CustomerRepository customerRepository;


    /**
     * Konstruktor für einen neuen CartController mit den nötigen Repositories
     * @param cartRepository
     * @param articleRepository
     * @param customerRepository
     */
    public CartController(CartRepository cartRepository, ArticleRepository articleRepository, CustomerRepository customerRepository) {
        this.cartRepository = cartRepository;
        this.articleRepository = articleRepository;
        this.customerRepository = customerRepository;
    }

    /**
     * Get Request der URL Endung '/cart' liefert alle Carts aus der DB
     * @return Liste mit allen CartItems in der DB
     */
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<CartItem> cart() {
        return cartRepository.findAll();
    }

    /**
     * Methode, die je nach übergebenen Werten und Vorhandensein in der DB ein Objekt aktualisiert, erstellt oder löscht
     * @param cartRequestItem, die im Post-Request verwendeten Werte für das Objekt
     * @return ResponseEntity, ein CartItemResponse, das die gesendeten Werte zurückgibt
     */
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CartItemResponse> createCart(@RequestBody CartItemRequest cartRequestItem) {
        CartItemId id = new CartItemId(
            articleRepository.getReferenceById(cartRequestItem.articleId),
            customerRepository.getReferenceById(cartRequestItem.customerId)
        );
        Optional<CartItem> item = cartRepository.findById(id);
        /**
         * Exisitert das Item bzw. die Instanz mit der ID bereits in der DB und ist die Menge größer 0 wird das Item in der DB aktualisiert
         */
        if(item.isPresent() && cartRequestItem.amount != 0){
            item.get().setAmount(cartRequestItem.amount);
            item.get().setPositionPrice(CartItem.calculatePositionPrice(item.get().getAmount(), id.getArticle().getArticlePrice()));
            CartItem result = cartRepository.save(item.get());
            return new ResponseEntity<CartItemResponse>(new CartItemResponse(result), HttpStatus.OK);
        }
        /**
         * Existiert die Instanz in der DB und ist die Menge = 0 wird die CartItemInstanz aus der DB gelöscht
         */
        else if(item.isPresent() && cartRequestItem.amount == 0) {
            cartRepository.delete(item.get());
            return new ResponseEntity<CartItemResponse>(new CartItemResponse(), HttpStatus.ACCEPTED);
        }
        /**
         * Erstellt eine Instanz in der DB sollte diese nicht vorhandensein
         */
        else{
            CartItem newItem = new CartItem();
            newItem.setAmount(cartRequestItem.amount);
            newItem.setArticle(id.getArticle());
            newItem.setCustomer(id.getCustomer());
            newItem.setPositionPrice(CartItem.calculatePositionPrice(newItem.getAmount(), id.getArticle().getArticlePrice()));
            CartItem result = cartRepository.save(newItem);
            return new ResponseEntity<CartItemResponse>(new CartItemResponse(result), HttpStatus.CREATED);
        }
    }

}