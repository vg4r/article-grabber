package net.sf.vgrs.gamesys.controller;

import net.sf.vgrs.gamesys.Application;
import net.sf.vgrs.gamesys.domain.Article;
import net.sf.vgrs.gamesys.domain.Response;
import net.sf.vgrs.gamesys.domain.exceptions.DBException;
import net.sf.vgrs.gamesys.service.ArticlesService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ArticleControllerTest {


    @Autowired
    private ArticleController controller;

    @Autowired
    private ArticlesService articlesService;

    @Before
    public void init() throws DBException {
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