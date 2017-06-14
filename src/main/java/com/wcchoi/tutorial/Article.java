package com.wcchoi.tutorial;

import lombok.Data;

import java.util.List;

/**
 * Created by 1002639 on 2017. 6. 14..
 */
@Data
public class Article {
    private long id;
    private String title;
    private String content;
    private List<Comment> comments;
}
