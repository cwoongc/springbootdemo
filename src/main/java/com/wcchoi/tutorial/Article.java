package com.wcchoi.tutorial;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 1002639 on 2017. 6. 14..
 */
@Data
public class Article implements Serializable {
    private long id;
    private String title;
    private String content;
    private List<Comment> comments;
}
