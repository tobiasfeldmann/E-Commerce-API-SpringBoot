package com.example.ECommerce.entities;

import com.example.ECommerce.CartItemId;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


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

}
