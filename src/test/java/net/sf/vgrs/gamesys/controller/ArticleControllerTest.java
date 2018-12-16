package net.sf.vgrs.gamesys.controller;

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
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static net.sf.vgrs.gamesys.utils.TestConstants.LIMIT_DEFAULT_VALUE;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ArticleControllerTest {


    private final List<Article> articles = Collections.singletonList(new Article());

    @Mock
    private ArticlesService articlesService;

    private ArticleController controller;

    @Before
    public void init() throws DBException {
        controller = new ArticleController(articlesService, LIMIT_DEFAULT_VALUE);
        Mockito.when(articlesService.get(1)).thenReturn(articles);
    }


    @Test
    public void get() {
        Response response = controller.get(Optional.of(1));
        assertEquals(Response.ResponseStatuses.OK.value(), response.getStatus());
        assertEquals(response.getArticles().size(), 1);
    }

    @Test
    public void testGetForDefaultValue() throws DBException {
        controller.get(Optional.empty());
        verify(articlesService).get(LIMIT_DEFAULT_VALUE);
    }
}