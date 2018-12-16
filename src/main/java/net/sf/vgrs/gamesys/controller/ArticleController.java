package net.sf.vgrs.gamesys.controller;

import net.sf.vgrs.gamesys.domain.Article;
import net.sf.vgrs.gamesys.domain.Response;
import net.sf.vgrs.gamesys.domain.exceptions.DBException;
import net.sf.vgrs.gamesys.service.ArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/articles")
public class ArticleController {


    private Integer limitDefault;

    private final ArticlesService articlesService;

    @Autowired
    public ArticleController(ArticlesService articlesService, @Value("${app.api.limit.def.value}")Integer limitDefault) {
        this.articlesService = articlesService;
        this.limitDefault = limitDefault;
    }


    /**
     * GET endpoint for getting articles from database.
     *
     * @param limit defines how many last row ro return.
     *              Default value of this param is defined in application.properties
     * @return Response object that holds list of articles, and response status
     */
    @GetMapping(value = {"/", "/{limit}"}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Response get(@PathVariable Optional<Integer> limit) {
        try {
            Response response = new Response();
            List<Article> articles = articlesService.get(limit.orElseGet(() -> limitDefault));
            response.setArticles(articles);
            return response;
        } catch (DBException e) {
            e.printStackTrace();
            return new Response(Response.ResponseStatuses.ERROR);
        }
    }

}
