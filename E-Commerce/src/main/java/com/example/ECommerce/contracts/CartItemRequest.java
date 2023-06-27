package com.example.ECommerce.contracts;

/**
 * Wird für die Verarbeitung von Requests verwendet.
 * Eingehende Daten aus Post Requests werden als CartItemRequest gespeichert/verarbeitet
 */
public class CartItemRequest {
    public int articleId;
    public int customerId;
    public int amount;
}
