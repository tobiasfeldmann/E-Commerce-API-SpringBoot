package com.example.ECommerce.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ECommerce.entities.Artikel;
import com.example.ECommerce.repositories.ArtikelRepository;

@RestController
@RequestMapping("/artikel")
public class ArtikelController {
    
    private ArtikelRepository artikelRepository;

    /**
     * weißt der Instanz eine übergebene Instanz der Klasse Artikel Repository zu
     * @param artikelRepository
     */
    public ArtikelController(ArtikelRepository artikelRepository) {
        this.artikelRepository = artikelRepository;
    }

    /**
     * Get Request für die URL Endung '/artikel' liefert alle Artikel aus der DB
     * @return
     */
    @GetMapping("")
    public List<Artikel> artikel() {
        return artikelRepository.findAll();
    }
}
