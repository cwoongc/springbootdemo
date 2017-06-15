package com.wcchoi.tutorial.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wcchoi.tutorial.Article;
import com.wcchoi.tutorial.Comment;
import com.wcchoi.tutorial.service.ArticleService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import org.apache.log4j.Logger;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;


/**
 * Created by 1002639 on 2017. 6. 15..
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleControllerTest {

    Logger logger = Logger.getLogger(this.getClass());

    private MockMvc mockMvc;

    @Autowired
    private ArticleController articleController;

    @Autowired
    private ArticleService articleService;


    @Before
    public void setUp() throws Exception {
        mockMvc = standaloneSetup(articleController).build();
    }

    private String jsonStringFromObject(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }

    @Test
    public void testIndex() throws Exception {
        List<Article> articles = articleService.getArticles();
        String jsonString = this.jsonStringFromObject(articles);

        mockMvc.perform(get("/api/articles"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().string(equalTo(jsonString)));

    }

    @Test
    public void testIndex2() throws Exception {
        List<Article> articles = articleService.getArticles();
        String jsonString = this.jsonStringFromObject(articles);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/articles"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().string(equalTo(jsonString)))
                .andReturn();

        logger.info(result.getResponse().getContentAsString());

    }

    @Test
    public void testShow() throws Exception {
        long id = 1;
        Article article = articleService.getArticle(id);
        String jsonString = this.jsonStringFromObject(article);

        mockMvc.perform(get("/api/articles/{id}",id))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().string(equalTo(jsonString)));
    }


    @Test
    public void testCreate() throws Exception {
        Article article = new Article();
        article.setTitle("testing create article");
        article.setContent("test content");

        Comment comment = new Comment();
        comment.setContent("test comment1");
        List<Comment> comments = new ArrayList<>();
        comments.add(comment);

        article.setComments(comments);

        String jsonString = this.jsonStringFromObject(article);

        MvcResult result = mockMvc.perform(
                post("/api/articles")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString)
        ).andExpect(status().isOk())
        .andExpect(content().string(equalTo(jsonString)))
        .andReturn();

        logger.info(result.getResponse().getContentAsString());

    }

    @Test
    public void testPatch() throws Exception {
        long id = 1;
        Article article = articleService.getArticle(id);
        article.setTitle("testing create article");
        article.setContent("test content");

        String jsonString = this.jsonStringFromObject(article);

        MvcResult result = mockMvc.perform(patch("/api/articles/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(jsonString))).andReturn();

        logger.info(result.getResponse().getContentAsString());
    }

    @Test
    public void testUpdate() throws Exception {
        long id = 1;
        Article article = articleService.getArticle(id);
        article.setTitle("testing create article");
        article.setContent("test content");

        String jsonString = this.jsonStringFromObject(article);

        MvcResult result = mockMvc.perform(put("/api/articles/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(jsonString))).andReturn();

        logger.info(result.getResponse().getContentAsString());
    }
}
