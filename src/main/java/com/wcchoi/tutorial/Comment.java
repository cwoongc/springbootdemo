package com.wcchoi.tutorial;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by 1002639 on 2017. 6. 14..
 */
@Data
public class Comment implements Serializable{
    private long id;
    private String content;
    private long articleId;
}
