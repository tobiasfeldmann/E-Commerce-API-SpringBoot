package com.example.ECommerce;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
@IdClass(CartItemId.class)
public class CartItem {

    public CartItem() {

    }

    public CartItem(CartRequestItem cartRequestItem){
        this.kundenID = cartRequestItem.getKundenID();
        this.anzahl = cartRequestItem.getAnzahl();
        this.artikelID = cartRequestItem.getArtikelID();
    }
    

    //soll automatisch von dem jeweiligen angemeldeteten kunden übernommmen werden

    @ManyToOne
    @JoinColumn(name = "kundenID")
    private Customer kunde;

    //ID des hinzugefügten artikels
    @ManyToOne
    @JoinColumn(name = "artikelID")
    private Artikel artikel;

    @Column
    private int anzahl;

    @Id
    @Column
    private int kundenID;

    @Id
    @Column
    private int artikelID;

    public Customer getKunde() {
        return this.kunde;
    }

    public void setKunde(Customer kunde) {
        this.kunde = kunde;
    }

    
    public Artikel getArtikel() {
        return this.artikel;
    }

    public void setArtikel(Artikel artikel) {
        this.artikel = artikel;
    }

    public int getAnzahl() {
        return this.anzahl;
    }

    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }

    public int getArtikelID() {
        return this.artikelID;
    }

    public void setArtikelID(int artikelID) {
        this.artikelID = artikelID;
    }

    public int getKundenID() {
        return this.kundenID;
    }

    public void setKundenID(int id) {
        this.kundenID = id;
    } 
    //TODO Summe der einzelnen Positionen plus Gesamtsumme Einkaufskorb
    //Array aus Objekten bsp Cartitem neue Klasse mit Id und anzahl
}
