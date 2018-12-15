package net.sf.vgrs.gamesys.controller;

import net.sf.vgrs.gamesys.domain.Article;
import net.sf.vgrs.gamesys.domain.Response;
import net.sf.vgrs.gamesys.domain.exceptions.DBException;
import net.sf.vgrs.gamesys.service.ArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    private final ArticlesService articlesService;

    @Autowired
    public ArticleController(ArticlesService articlesService) {
        this.articlesService = articlesService;
    }


    /**
     * GET endpoint for getting articles from database.
     *
     * @param limit defines how many last row ro return
     * @return Response object that holds list of articles, and response status
     */
    @GetMapping(value = "/{limit}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Response get(@PathVariable int limit) {
        try {
            Response response = new Response();
            List<Article> articles = articlesService.get(limit);
            response.setArticles(articles);
            return response;
        } catch (DBException e) {
            e.printStackTrace();
            return new Response(Response.ResponseStatuses.ERROR);
        }
    }

}
