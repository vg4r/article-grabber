package net.sf.vgrs.gamesys.controller;

import net.sf.vgrs.gamesys.dao.ArticlesDao;
import net.sf.vgrs.gamesys.domain.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    @Qualifier("dbProvider")
    private ArticlesDao articlesDao;

    /**
     * GET endpoint for getting articles from database.
     * @param limit defines how many last rorw ro return
     * @return
     */
    @GetMapping(value = "/{limit}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Article> get(@PathVariable int limit) {
        return articlesDao.get(limit);
    }

}
