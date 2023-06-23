package com.example.ECommerce;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Artikel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int artikelID;

    private String artikelBezeichnung;
    
    private int price;

    @OneToMany(mappedBy = "artikel")
    private List<CartItem> cartItems;

    public List<CartItem> getCartItems() {
        return this.cartItems;
    }

    public int getArtikelID() {
        return this.artikelID;
    }

    public void setArtikelID(int id) {
        this.artikelID = id;
    }

    public String getArtikelbezeichnung() {
        return this.artikelBezeichnung;
    }

    public void setArtikelbezeichnung(String name) {
        this.artikelBezeichnung = name;
    }

}
