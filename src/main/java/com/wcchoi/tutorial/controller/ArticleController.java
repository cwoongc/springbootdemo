package com.wcchoi.tutorial.controller;

import com.wcchoi.tutorial.Article;
import com.wcchoi.tutorial.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by 1002639 on 2017. 6. 15..
 */
@RestController
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @RequestMapping(value = "/api/articles", method = RequestMethod.GET)
    public List<Article> index() {
        return articleService.getArticles();
    }

    @RequestMapping(value="/api/articles/{id}", method=RequestMethod.GET)
    public Article show(@PathVariable(value="id") long id) {
        return articleService.getArticle(id);
    }

    @RequestMapping(value="/api/articles", method=RequestMethod.POST)
    public Article create(@RequestBody Article article) {
        return article;
    }

    @RequestMapping(value="/api/articles/{id}", method=RequestMethod.PATCH)
    public Article patch(@PathVariable(value="id") long id, @RequestBody Article article) {

        return article;
    }

    @RequestMapping(value="/api/articles/{id}", method=RequestMethod.PUT)
    public Article update(@PathVariable(value="id") long id, @RequestBody Article article) {

        return article;
    }

}
