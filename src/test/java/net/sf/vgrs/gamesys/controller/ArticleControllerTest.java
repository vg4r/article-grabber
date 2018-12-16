package net.sf.vgrs.gamesys.controller;

import net.sf.vgrs.gamesys.Application;
import net.sf.vgrs.gamesys.domain.Article;
import net.sf.vgrs.gamesys.domain.Response;
import net.sf.vgrs.gamesys.domain.exceptions.DBException;
import net.sf.vgrs.gamesys.service.ArticlesService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ArticleControllerTest {

    @Mock
    private ArticlesService articlesService;

    private ArticleController controller;

    @Before
    public void init() throws DBException {
        controller = new ArticleController(articlesService);
        Article article = new Article();
        List<Article> articles = Collections.singletonList(article);
        Mockito.when(articlesService.get(1)).thenReturn(articles);
    }


    @Test
    public void get() {
        Response response = controller.get(1);
        assertEquals(Response.ResponseStatuses.OK.value(), response.getStatus());
        assertEquals(response.getArticles().size(), 1);
    }
}