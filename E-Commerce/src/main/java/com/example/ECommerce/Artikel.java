package com.example.ECommerce;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Artikel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int artikelID;

    private String artikelBezeichnung;

    private int anzahl;

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

    public String getArtikelbezeichnung() {
        return this.artikelBezeichnung;
    }

    public void setArtikelbezeichnung(String name) {
        this.artikelBezeichnung = name;
    }

}
