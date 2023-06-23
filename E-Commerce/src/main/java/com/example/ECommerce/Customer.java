package com.example.ECommerce;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int kundenID;

    private String vorname;

    private String nachname;

    

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


