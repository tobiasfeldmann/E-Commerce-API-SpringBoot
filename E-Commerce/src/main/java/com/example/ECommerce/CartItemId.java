package com.example.ECommerce;

import java.io.Serializable;

public class CartItemId implements Serializable {
    private int kundenID;
    private int artikelID;

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
    
}

