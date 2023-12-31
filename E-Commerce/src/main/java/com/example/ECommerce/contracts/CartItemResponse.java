package com.example.ECommerce.contracts;

import com.example.ECommerce.entities.CartItem;
/**
 * Dient der Antwort auf Requests bzw. bildet die Antwort aus den Attributen.
 */
public class CartItemResponse {
    public int articleId;
    public int customerId;
    public int amount;
    public float positionPrice;

    /**
     * Default Konstruktor
     */
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
        float singlePrice = item.getArticle().getArticlePrice();
        positionPrice = CartItem.calculatePositionPrice(amount, singlePrice);
    }
}
