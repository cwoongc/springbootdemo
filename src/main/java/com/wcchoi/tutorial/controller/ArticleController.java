package com.wcchoi.tutorial.controller;

import com.wcchoi.tutorial.Article;
import com.wcchoi.tutorial.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

}
