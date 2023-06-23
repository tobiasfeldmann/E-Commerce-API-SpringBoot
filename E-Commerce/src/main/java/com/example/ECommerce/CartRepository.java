package com.example.ECommerce;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartItem, Integer> {
    List<CartItem> findByKundenIDAndArtikelID(int kundenID, int artikelID);
}
