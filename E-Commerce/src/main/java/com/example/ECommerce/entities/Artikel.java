package com.example.ECommerce.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Artikel {

    /**
     * einzigartige Nummer zur Identifikation des Artikels in der DB
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int articleId;

    @Column(name = "article_description")
    private String articleDescription;

    @Column(name = "article_price")
    private float articlePrice;

    public float getArticlePrice() {
        return this.articlePrice;
    }

    public void setArticlePrice(float price) {
        this.articlePrice = price;
    }

    public int getArticleId() {
        return this.articleId;
    }

    public void setArticleId(int id) {
        this.articleId = id;
    }

    public String getArticleDescription() {
        return this.articleDescription;
    }

    public void setArticleDescription(String name) {
        this.articleDescription = name;
    }

}
