package com.example.ECommerce;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/artikel")
public class ArtikelController {
    
    private ArtikelRepository artikelRepository;

    public ArtikelController(ArtikelRepository artikelRepository) {
        this.artikelRepository = artikelRepository;
    }

    @GetMapping("")
    public List<Artikel> artikel() {
        return artikelRepository.findAll();
    }
}
