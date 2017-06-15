package com.wcchoi.tutorial.service;

import com.wcchoi.tutorial.Article;
import com.wcchoi.tutorial.FixtureProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by 1002639 on 2017. 6. 15..
 */
@Service
public class ArticleService {

    @Autowired
    FixtureProperties fixtureProperties;

    public List<Article> getArticles() {
        List<Article> articles = new ArrayList<>(fixtureProperties.getArticles());
        return articles;
    }

    public Article getArticle(long id) {
        List<Article> articles = this.getArticles();
        Article article = articles.stream()
                .filter(a -> a.getId() == id)
                .collect(Collectors.toList()).get(0);
        return article;
    }

    public List<Article> deleteArticle(long id) {
        List<Article> articles = this.getArticles();
        articles.removeIf(a -> a.getId() == id);
        return articles;
    }


}
