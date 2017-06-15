package com.wcchoi.tutorial;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by 1002639 on 2017. 6. 14..
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FixturePropertyTest {

    @Autowired
    private FixtureProperties fixtureProperties;

    @Test
    public void testGetArticles() {
        List<Article> articles = fixtureProperties.getArticles();
        assertThat(articles.size(),is(3));
    }

    @Test
    public void testGetCommentsByArticles() {
        List<Article> articles = fixtureProperties.getArticles();
        Article article = articles.get(0);
        List<Comment> comments =  article.getComments();
        assertThat(comments.size(), is(2));
    }
}
