package com.temp.wedding_secretary.mappers;

import com.temp.wedding_secretary.constants.Columns;
import com.temp.wedding_secretary.models.domain.Article;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ArticleMapper implements RowMapper<Article> {

    @Nullable
    @Override
    public Article mapRow(ResultSet resultSet, int i) throws SQLException {
        Article article = new Article();
        article.setTitle(resultSet.getString(Columns.TITLE));
        article.setPreview(resultSet.getString(Columns.PREVIEW));
        article.setText(resultSet.getString(Columns.TEXT));
        article.setImages((List<Object>) resultSet.getArray(Columns.IMAGES));
        article.setIcon(resultSet.getObject(Columns.ICON));
        return article;
    }
}
