package com.temp.wedding_secretary.dao;

import com.temp.wedding_secretary.models.domain.Article;

import java.util.List;

public interface ArticleDao {

    /**
     * получить данные для сущности "Статья"
     *
     * @return возвращает список сущностей с данными
     */
    List<Article> getArticles();
}
