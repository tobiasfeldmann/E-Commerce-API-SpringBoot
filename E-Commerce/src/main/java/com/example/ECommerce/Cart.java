package com.example.ECommerce;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cart {

    public Cart (int kundenID, int artikelID, int anzahl) {
        this.kundenID = kundenID;
        this.artikelID = artikelID;
        this.anzahl = anzahl;
    }

    //soll automatisch von dem jeweiligen angemeldeteten kunden übernommmen werden
    @Id
    private int kundenID;

    //ID des hinzugefügten artikels
    private int artikelID;

    //anzahl des artikel
    private int anzahl;

    public int getKundenID() {
        return this.kundenID;
    }

    public void setKundenID(int id) {
        this.kundenID = id;
    } 

    public int getArtikelID() {
        return this.artikelID;
    }

    public void setArtikelID(int id) {
        this.artikelID = id;
    }

    public int getAnzahl() {
        return this.anzahl;
    }

    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }
}
