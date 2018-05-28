package com.temp.wedding_secretary.dao.impl;

import com.temp.wedding_secretary.constants.Columns;
import com.temp.wedding_secretary.dao.ArticleDao;
import com.temp.wedding_secretary.mappers.ArticleMapper;
import com.temp.wedding_secretary.models.domain.Article;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Repository
public class ArticleDaoImpl implements ArticleDao {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private String articlesSql;
    private String imageLinksSql;

    public ArticleDaoImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Article> getArticles() {
        List<Article> articles = jdbcTemplate.query(articlesSql, new ArticleMapper());
        articles.forEach(article -> {
            MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
            mapSqlParameterSource.addValue(Columns.CODE, article.getCode());
            article.setImageLinks(jdbcTemplate.queryForList(imageLinksSql, mapSqlParameterSource, String.class));
        });
        return articles;
    }

    @Autowired
    public void setArticles(@Value("classpath:scripts/dao/articles_select.sql") InputStream sqlStream) throws IOException {
        this.articlesSql = IOUtils.toString(sqlStream);
    }

    @Autowired
    public void setImageLinks(@Value("classpath:scripts/dao/images_select.sql") InputStream sqlStream) throws IOException {
        this.imageLinksSql = IOUtils.toString(sqlStream);
    }
}
