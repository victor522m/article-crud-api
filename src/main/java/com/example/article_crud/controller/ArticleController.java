package com.example.article_crud.controller;

import com.example.article_crud.entity.Article;
import com.example.article_crud.repository.ArticleRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    private final ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    // GET - Obtener todos los artículos. 
    @GetMapping
    @Transactional(readOnly = true)
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    // GET - Obtener un artículo por ID
    @GetMapping("/{id}")
    @Transactional(readOnly = true)
    public ResponseEntity<Article> getArticleById(@PathVariable int id) {
        return articleRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST - Crear un artículo
    @PostMapping
    @Transactional
    public Article createArticle(@RequestBody Article article) {
        return articleRepository.save(article);
    }

    // PUT - Actualizar un artículo
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Article> updateArticle(@PathVariable int id, @RequestBody Article articleDetails) {
        return articleRepository.findById(id).map(article -> {
            article.setName(articleDetails.getName());
            article.setFeatures(articleDetails.getFeatures());
            article.setDescription(articleDetails.getDescription());
            article.setImageUrl(articleDetails.getImageUrl());
            Article updatedArticle = articleRepository.save(article);
            return ResponseEntity.ok(updatedArticle);
        }).orElse(ResponseEntity.notFound().build());
    }

    // DELETE - Eliminar un artículo
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deleteArticle(@PathVariable int id) {
        if (articleRepository.existsById(id)) {
            articleRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    //POST - Crear n articulos de golpe
    @PostMapping("/bulk")
    @Transactional
    public List<Article> createArticles(@RequestBody List<Article> articles) {
        return articleRepository.saveAll(articles);
    }
}
