package com.example.ECommerce;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Customer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int kundenID;

    private String vorname;

    private String nachname;

    @OneToMany(mappedBy = "kunde")
    private List<CartItem> cartItems;

    public List<CartItem> getCartItems(){
        return this.cartItems;
    }

    public String getVorname() {
        return this.vorname;
    }

    public String getNachname() {
        return this.nachname;
    }

    public int getkundenID() {
        return this.kundenID;
    }

    public void setVorname(String vorname){
        this.vorname = vorname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public void setId(int kundenID) {
        this.kundenID = kundenID;
    }


}


