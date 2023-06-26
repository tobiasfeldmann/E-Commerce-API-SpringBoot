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

    /**
     * Artikel Beschreibung 
     */
    @Column(name = "article_description")
    private String articleDescription;

    /**
     * Preis des Artikels pro Stück ggf. pro anderweitig festgelegter Mengeneinheit
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
     * Set Methode für den Artikel preis
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
     * @param id, neue ID des Artikels
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
