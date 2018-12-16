package net.sf.vgrs.gamesys.service;

import net.sf.vgrs.gamesys.dao.ArticlesDao;
import net.sf.vgrs.gamesys.dao.JdbcConnectionManager;
import net.sf.vgrs.gamesys.domain.Article;
import net.sf.vgrs.gamesys.domain.exceptions.DBException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static net.sf.vgrs.gamesys.utils.TestConstants.ARTICLE_LIST_1;
import static net.sf.vgrs.gamesys.utils.TestConstants.ARTICLE_LIST_3;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ArticlesServiceTest {

    @Mock
    private JdbcConnectionManager connectionManager;

    @Mock
    private ArticlesDao articlesDao;

    private ArticlesService articlesService;

    @Before
    public void init() {
        articlesService = new ArticlesService(connectionManager, articlesDao);
    }

    @Test
    public void add() throws DBException {
        Mockito.when(articlesDao.add(Mockito.anyList())).thenReturn(2L);
        long count = articlesService.add(ARTICLE_LIST_3);
        assertEquals(2, count);
    }

    @Test
    public void get() throws DBException {
        Mockito.when(articlesDao.get(2)).thenReturn(ARTICLE_LIST_1);
        List<Article> articles = articlesService.get(2);
        assertEquals(2, articles.size());
    }
}