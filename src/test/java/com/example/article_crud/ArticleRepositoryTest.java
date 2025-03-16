package com.example.article_crud;

import com.example.article_crud.entity.Article;
import com.example.article_crud.repository.ArticleRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ArticleRepositoryTest {

    @Autowired
    private ArticleRepository articleRepository;

    @Test
    void shouldSaveAndFindArticle() {
        Article article = new Article("Tablet", "Feature X, Feature Y", "A powerful tablet", "http://example.com/tablet.jpg");
        Article savedArticle = articleRepository.save(article);

        Optional<Article> retrievedArticle = articleRepository.findById(savedArticle.getId());
        assertThat(retrievedArticle).isPresent();
        assertThat(retrievedArticle.get().getName()).isEqualTo("Tablet");
    }

    @Test
    void shouldReturnAllArticles() {
        Article article1 = new Article("Article 1", "Feature A", "Description 1", "http://example.com/article1.jpg");
        Article article2 = new Article("Article 2", "Feature B", "Description 2", "http://example.com/article2.jpg");
        articleRepository.save(article1);
        articleRepository.save(article2);

        List<Article> articles = articleRepository.findAll();
        assertThat(articles).hasSize(2);
    }

    @Test
    void shouldDeleteArticle() {
        Article article = new Article("Article to Delete", "Feature X", "To be deleted", "http://example.com/delete.jpg");
        Article savedArticle = articleRepository.save(article);

        articleRepository.deleteById(savedArticle.getId());

        Optional<Article> deletedArticle = articleRepository.findById(savedArticle.getId());
        assertThat(deletedArticle).isNotPresent();
    }
}