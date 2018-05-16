package com.temp.wedding_secretary.services;

import com.temp.wedding_secretary.dao.ArticleDao;
import com.temp.wedding_secretary.models.domain.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    private final ArticleDao articleDao;

    @Autowired
    public ArticleService(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    public List<Article> getArticles() {
        return articleDao.getArticles();
    }
}
