package com.wcchoi.tutorial.service;

import com.wcchoi.tutorial.Article;
import com.wcchoi.tutorial.FixtureProperties;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Created by 1002639 on 2017. 6. 15..
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleServiceTest {

    @Autowired
    ArticleService articleService;

    @Autowired
    FixtureProperties fixtureProperties;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testGetArticles() throws Exception {
        List<Article> articles = articleService.getArticles();
        assertThat(articles, is(notNullValue()));
        assertThat(articles.size(), is(3));
    }

    @Test
    public void testGetArticle() throws Exception {
        long id = 1;
        Article article = articleService.getArticle(id);

        List<Article> articles = fixtureProperties.getArticles();
        Article demoArticle = articles.stream()
                .filter( a -> a.getId() == id)
                .collect(Collectors.toList()).get(0);

        assertThat(article.getId(), is(equalTo(demoArticle.getId())));
    }

    @Test
    public void testDeleteArticle() throws Exception {
        long id = 1;
        List<Article> demoArticles = new ArrayList<>(fixtureProperties.getArticles());
        List<Article> articles = articleService.deleteArticle(id);
        assertThat(articles.size(), not(demoArticles.size()));
    }






}
