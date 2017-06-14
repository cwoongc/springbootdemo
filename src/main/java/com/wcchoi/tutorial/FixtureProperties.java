package com.wcchoi.tutorial;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by 1002639 on 2017. 6. 14..
 */
@Component
@ConfigurationProperties(prefix = "fixtures")
public class FixtureProperties {

    private List<Article> articles = new ArrayList<>();

    public List<Article> getArticles() {
        return articles;
    }
}
