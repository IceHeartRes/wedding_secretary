package com.temp.wedding_secretary.mappers;

import com.temp.wedding_secretary.constants.Columns;
import com.temp.wedding_secretary.models.domain.Article;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticleMapper implements RowMapper<Article> {

    @Nullable
    @Override
    public Article mapRow(ResultSet resultSet, int i) throws SQLException {
        Article article = new Article();
        article.setTitle(resultSet.getString(Columns.TITLE));
        article.setPreview(resultSet.getString(Columns.PREVIEW));
        article.setText(resultSet.getString(Columns.TEXT));
        article.setIconLink(resultSet.getString(Columns.ICON_LINK));
        article.setCode(resultSet.getString(Columns.CODE));
        return article;
    }
}
