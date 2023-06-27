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
    private Article article;

    @Column(name = "amount")
    private int amount;

    @Column(name = "position_price")
    private float positionPrice;

    
    /** 
     * Get Methode für den Customer
     * @return Customer, Instanz der Klasse Customer
     */
    public Customer getCustomer() {
        return this.customer;
    }

    
    /** 
     * Set Methode für den Customer
     * @param customer, Instanz der Klasse Custoemr
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    
    
    /** 
     * Get Methode des Artikels
     * @return article, Instanz der Klasse Article
     */
    public Article getArticle() {
        return this.article;
    }

    /**
     * Set Methode für den Artikel
     * @param article, Instanz der Klasse Article
     */
    public void setArticle(Article article) {
        this.article = article;
    }

    /**
     * Get Methode für die Anzahl
     * @return jeweilige Anzahl des Artikels
     */
    public int getAmount() {
        return this.amount;
    }

    /**
     * Set Methode für die Anzahl
     * @param amount, neuer Wert für die Anzahl
     */
    public void setAmount(int amount) {
        this.amount = amount;
    } 

    /**
     * Get Methode für den Positions Preis bzw. Preis pro Mengeneinheit
     * @return Preis pro Mengeneinheit des entsprechenden Artikel
     */
    public float getPositionPrice() {
        return this.positionPrice;
    }

    /**
     * Set Methode für den Preis pro Mengeneinheit
     * @param price, neuer Wert für den Preis pro Mengeneinheit
     */
    public void setPositionPrice(float price) {
        this.positionPrice = price;
    }

    /**
     * Berechnet den Preis für die einzelne Position bzw. für ein CartItem zu einer jeweiligen articleID
     * @param amount, anzahl der Position
     * @param price, Preis des Artikels pro Stück
     * @return
    */
    public static float calculatePositionPrice(int amount, float price) {
        float result = amount * price;
        return result;
    }

}
