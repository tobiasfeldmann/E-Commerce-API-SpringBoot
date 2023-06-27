package com.example.ECommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ECommerce.entities.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

}
