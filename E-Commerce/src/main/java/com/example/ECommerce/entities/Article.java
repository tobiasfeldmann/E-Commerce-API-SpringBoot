package com.example.ECommerce.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Stellt einen article mit einer eindeutigen article ID, einem Preis sowie einer Beschreibung dar.
 */
@Entity
public class Article {

    /**
     * einzigartige Nummer zur Identifikation des articles in der DB
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int articleId;

    /**
     * article Beschreibung 
     */
    @Column(name = "article_description")
    private String articleDescription;

    /**
     * Preis des articles pro Stück ggf. pro anderweitig festgelegter Mengeneinheit
     */
    @Column(name = "article_price")
    private float articlePrice;

    /**
     * Get Methode für den Artikelpreis
     * @return Preis des Artikels
     */
    public float getArticlePrice() {
        return this.articlePrice;
    }

    /**
     * Set Methode für den Artikelpreis
     * @param price, neuer Preis für den Artikel
     */
    public void setArticlePrice(float price) {
        this.articlePrice = price;
    }

    /**
     * Get Methode für die Artikel ID
     * @return gibt die Artikel ID aus
     */
    public int getArticleId() {
        return this.articleId;
    }

    /**
     * Set Methode für die Artikel ID
     * @param id, neue ID des Artikel
     */
    public void setArticleId(int id) {
        this.articleId = id;
    }

    /**
     * Get Methode für die Artikelbeschreibung
     * @return gibt die Artikelbeschreibung aus
     */
    public String getArticleDescription() {
        return this.articleDescription;
    }

    /**
     * Set Methode für die Artikelbeschreibung
     * @param name, neuer Wert für die Artikelbeschreibung
     */
    public void setArticleDescription(String name) {
        this.articleDescription = name;
    }

}
