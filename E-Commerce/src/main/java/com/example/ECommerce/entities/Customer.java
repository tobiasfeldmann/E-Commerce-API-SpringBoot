package com.example.ECommerce.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Stellt einen Kunden mit einer eindeutigen KundenID, sowie Vor- und Nachnamen dar
 */
@Entity
public class Customer {
    /**
     * Wird als ID in der DB verwendet, stellt eine einzigartige Nummer pro Kunde dar
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    /**
     * Vorname des Kunden
     */
    @Column(name = "first_name")
    private String firstName;

    /**
     *Nachname des Kunden
     */
    @Column(name = "last_name")
    private String lastName;

    /**
     * Get Methode für den Vornamen
     * @return gibt den Vornamen des Kunden aus
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Get Methode für den Nachnamen
     * @return gibt den Nachnamen des Kunden aus
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Get Methode für die KundenID
     * @return gibt die KundenID aus
     */
    public int getCustomerId() {
        return this.customerId;
    }

    /**
     * Set Methode für den Vornamen
     * @param vorname, neuer Vorname
     */
    public void setFirstName(String vorname){
        this.firstName = vorname;
    }

    /**
     * Set Methode für den Nachnamen
     * @param nachname, neuer Wert für den Nachnamen
     */
    public void setLastName(String nachname) {
        this.lastName = nachname;
    }

    /**
     * Set Methode für die KundenID
     * @param customerId, neuer Wert für die KundenID
     */
    public void setId(int customerId) {
        this.customerId = customerId;
    }


}


