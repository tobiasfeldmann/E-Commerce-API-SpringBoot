package com.example.ECommerce;

import com.example.ECommerce.entities.Artikel;
import com.example.ECommerce.entities.Customer;

/**
 * Dient als ID Class für CartItem.
 * Identifizierung des CartItems über die Customer ID und Article ID
 */
public class CartItemId {
    
    private Artikel article;
    private Customer customer;

    public CartItemId() {

    }

    /**
     * Konstruktor, erstellt aus zwei Instanzen der Klasse artikel und customer eine Instanz
     * dient der Auflistung verschiedener Einträge bzw. Positionen in einem Warenkorb
     * Zuordnung zu dem Kunden per KundenID möglich
     * @param artikel
     * @param customer
     */
    public CartItemId(Artikel artikel, Customer customer){
        this.article = artikel;
        this.customer = customer;
    }


    /**
     * Get Methode für den Artikel des CartItem
     * @return Instanz der Klasse Artikel
     */
    public Artikel getArticle() {
        return this.article;
    }

    /**
     * Set Methode für den Artikel des CartItem
     * @param artikel, Instanz der Klasse Artikel
     */
    public void setArticle(Artikel artikel) {
        this.article = artikel;
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

