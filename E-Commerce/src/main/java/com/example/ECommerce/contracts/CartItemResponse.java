package com.example.ECommerce.contracts;

import com.example.ECommerce.entities.CartItem;

public class CartItemResponse {
    public int articleId;
    public int customerId;
    public int amount;

    public CartItemResponse() {
    }

    /**
     * Konstruktor, der aus einem übergebenen CartItem ein CartItemResponse zur Rückgabe nach einem Request liefert
     * @param item, Instanz der Klasse CartItem
     */
    public CartItemResponse(CartItem item) {
        articleId = item.getArticle().getArticleId();
        customerId = item.getCustomer().getCustomerId();
        amount = item.getAmount();
    }
}
