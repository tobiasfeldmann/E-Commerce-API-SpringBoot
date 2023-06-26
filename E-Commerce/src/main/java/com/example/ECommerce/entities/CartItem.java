package com.example.ECommerce.entities;

import com.example.ECommerce.CartItemId;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * ID Klasse für CartItem.
 * Dient der Identifizierung eines CartItems zu einem jeweiligen Kunden über die Customer ID und die Article ID
 */
@Entity
@IdClass(CartItemId.class)
public class CartItem {

    @Id
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @Id
    @ManyToOne
    @JoinColumn(name = "articleId")
    private Artikel article;

    @Column(name = "amount")
    private int amount;

    @Column(name = "position_price")
    private float positionPrice;

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    
    public Artikel getArticle() {
        return this.article;
    }

    public void setArticle(Artikel artikel) {
        this.article = artikel;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    } 

    public float getPositionPrice() {
        return this.positionPrice;
    }

    public void setPositionPrice(float price) {
        this.positionPrice = price;
    }

    /**
     * Berechnet den Preis für die einzelne Position bzw. für ein CartItem zu einer jeweiligen ArtikelID
     * @param amount, anzahl der Position
     * @param price, Preis des Artikels pro Stück
     * @return
    */
    public static float calculatePositionPrice(int amount, float price) {
        float result = amount * price;
        return result;
    }

}
