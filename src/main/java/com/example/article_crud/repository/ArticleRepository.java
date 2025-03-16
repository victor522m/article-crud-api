package com.example.article_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.article_crud.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer> { // ID ahora es Integer
}