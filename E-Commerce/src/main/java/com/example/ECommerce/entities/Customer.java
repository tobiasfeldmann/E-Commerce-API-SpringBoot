package com.example.ECommerce.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
    /**
     * Wird als ID in der DB verwendet, stellt eine einzigartige Nummer pro Kunde dar
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getCustomerId() {
        return this.customerId;
    }

    public void setFirstName(String vorname){
        this.firstName = vorname;
    }

    public void setLastName(String nachname) {
        this.lastName = nachname;
    }

    public void setId(int customerId) {
        this.customerId = customerId;
    }


}


