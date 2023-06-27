package com.example.ECommerce;

import com.example.ECommerce.entities.Article;
import com.example.ECommerce.entities.Customer;

/**
 * Dient als ID Class für CartItem.
 * Identifizierung des CartItems über die Customer ID und Article ID
 */
public class CartItemId {
    
    private Article article;
    private Customer customer;

    public CartItemId() {

    }

    /**
     * Konstruktor, erstellt aus zwei Instanzen der Klasse Article und Customer eine Instanz
     * dient der Auflistung verschiedener Einträge bzw. Positionen in einem Warenkorb
     * Zuordnung zu dem Kunden per KundenID möglich
     * @param article
     * @param customer
     */
    public CartItemId(Article article, Customer customer){
        this.article = article;
        this.customer = customer;
    }


    /**
     * Get Methode für den Artikel des CartItem
     * @return Instanz der Klasse Article
     */
    public Article getArticle() {
        return this.article;
    }

    /**
     * Set Methode für den Artikel des CartItem
     * @param article, Instanz der Klasse Article
     */
    public void setArticle(Article article) {
        this.article = article;
    }

    /**
     * Get Methode für den Customer des CartItem
     * @return Instanz der Klasse Customer
     */
    public Customer getCustomer() {
        return this.customer;
    }

    /**
     * Set Methode für den Customer des CartItem
     * @param customer, Instanz der Klasse Customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    
}

