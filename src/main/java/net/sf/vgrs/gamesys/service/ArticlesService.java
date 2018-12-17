package net.sf.vgrs.gamesys.service;

import net.sf.vgrs.gamesys.dao.ArticlesDao;
import net.sf.vgrs.gamesys.domain.Article;
import net.sf.vgrs.gamesys.domain.exceptions.DBException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticlesService {

    private final ArticlesDao articlesDao;
    private static final Logger logger = LoggerFactory.getLogger(ArticlesService.class);

    public ArticlesService(@Qualifier("dbProvider") ArticlesDao articlesDao) {
        this.articlesDao = articlesDao;
    }

    public long add(List<Article> articles) throws DBException {
        //Filter articles that have Author. The Articles that doesn't have Author will be omitted
        List<Article> filteredArticles = articles.stream()
                .filter(e -> e.getAuthor() != null)
                .collect(Collectors.toList());
        logger.trace("{} articles removed from list", articles.size() - filteredArticles.size());

        long addCount = articlesDao.add(filteredArticles);
        logger.trace("Added {} articles from {}", addCount, filteredArticles.size());
        return addCount;
    }

    public List<Article> get(int limit) throws DBException {
        return articlesDao.get(limit);
    }

}
