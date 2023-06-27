package com.example.ECommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ECommerce.entities.Article;

/**
 * Dient dem Zugriff auf die DB für die Tabelle article
 */
public interface ArticleRepository extends JpaRepository<Article, Integer> {

}
