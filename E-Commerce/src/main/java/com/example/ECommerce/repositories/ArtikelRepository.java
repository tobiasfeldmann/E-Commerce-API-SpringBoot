package com.example.ECommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ECommerce.entities.Artikel;

public interface ArtikelRepository extends JpaRepository<Artikel, Integer> {

}
