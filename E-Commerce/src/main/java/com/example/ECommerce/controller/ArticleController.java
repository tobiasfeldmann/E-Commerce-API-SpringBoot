package com.example.ECommerce.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ECommerce.entities.Article;
import com.example.ECommerce.repositories.ArticleRepository;

/**
 * Controller für Request der URL Endung '/article'
 */
@RestController
@RequestMapping("/article")
public class ArticleController {
    
    private ArticleRepository articleRepository;

    /**
     * weißt der Instanz eine übergebene Instanz der Klasse Article Repository zu
     * @param ArticleRepository, Instanz der Klasse ArticleRepository
     */
    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    /**
     * Get Request für die URL Endung '/article' liefert alle article aus der DB
     * @return Liste mit allen gefundenen Artikeln aus der DB
     */
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Article> article() {
        return articleRepository.findAll();
    }
}
