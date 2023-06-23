package com.example.ECommerce;

public class CartRequestItem {
    private int kundenID;
    private int artikelID;
    private int anzahl;
    
    public int getKundenID() {
        return this.kundenID;
    }

    public void setKundenID(int kundenID) {
        this.kundenID = kundenID;
    }

    public int getArtikelID() {
        return this.artikelID;
    }

    public void setArtikelID(int artikelID) {
        this.artikelID = artikelID;
    }

    public int getAnzahl() {
        return this.anzahl;
    }

    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }

}
