package wedding_secretary.temp.dao.impl;

import com.temp.wedding_secretary.dao.ArticleDao;
import com.temp.wedding_secretary.models.domain.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import wedding_secretary.temp.wedding_secretary.PropertiesConfig;
import wedding_secretary.temp.wedding_secretary.constants.Constants;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class ArticleDaoImplTest extends PropertiesConfig.CommonContextConfigurationTest {

    @Autowired
    private ArticleDao articleDao;

    @Test
    @Sql({"articles_clear.sql", "articles_insert.sql"})
    @Sql(scripts = "articles_clear.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void getArticlesTest() throws Exception {

        List<Article> articles = articleDao.getArticles();
        Article article = articles.get(0);
        List<String> imageLinks = article.getImageLinks();

        assertNotNull(articles);
        assertEquals(1, articles.size());
        assertEquals(Constants.CODE, article.getCode());
        assertEquals(Constants.PREVIEW, article.getPreview());
        assertEquals(Constants.TEXT, article.getText());
        assertEquals(Constants.TITLE, article.getTitle());
        assertEquals(Constants.ICON_LINK, article.getIconLink());

        assertNotNull(imageLinks);
        assertEquals(1, imageLinks.size());
        assertEquals(Constants.IMAGE_LINK, imageLinks.get(0));

    }
}
