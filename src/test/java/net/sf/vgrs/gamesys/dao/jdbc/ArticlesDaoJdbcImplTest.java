package net.sf.vgrs.gamesys.dao.jdbc;

import net.sf.vgrs.gamesys.Application;
import net.sf.vgrs.gamesys.dao.ArticlesDao;
import net.sf.vgrs.gamesys.dao.JdbcConnectionManager;
import net.sf.vgrs.gamesys.domain.Article;
import net.sf.vgrs.gamesys.domain.exceptions.DBException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.util.List;

import static net.sf.vgrs.gamesys.utils.TestConstants.ARTICLE_LIST_1;
import static net.sf.vgrs.gamesys.utils.TestConstants.ARTICLE_LIST_2;
import static org.junit.Assert.assertEquals;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ArticlesDaoJdbcImplTest {

    @Autowired
    private DataSource dataSource;

    private JdbcConnectionManager connectionManager;


    private ArticlesDao articlesDao;

    @Before
    public void init() {
        connectionManager = new JdbcConnectionManager(dataSource);
        articlesDao = new ArticlesDaoJdbcImpl(connectionManager);
    }

    @After
    public void after() throws DBException {
        articlesDao.delete();
    }

    @Test
    public void add() throws DBException {
        long count1 = articlesDao.add(ARTICLE_LIST_1);
        assertEquals(count1, 2);

        long count2 = articlesDao.add(ARTICLE_LIST_2);
        assertEquals(count2, 1);
    }

    @Test
    public void get() throws DBException {
        long count = articlesDao.add(ARTICLE_LIST_1);
        assertEquals(2, count);
        List<Article> articles = articlesDao.get(100);
        assertEquals(count, articles.size());
    }
}