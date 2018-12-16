package net.sf.vgrs.gamesys.service;

import net.sf.vgrs.gamesys.dao.ArticlesDao;
import net.sf.vgrs.gamesys.dao.JdbcConnectionManager;
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

    private final JdbcConnectionManager connectionManager;
    private final ArticlesDao articlesDao;
    Logger logger = LoggerFactory.getLogger(ArticlesService.class);

    public ArticlesService(JdbcConnectionManager connectionManager, @Qualifier("dbProvider") ArticlesDao articlesDao) {
        this.connectionManager = connectionManager;
        this.articlesDao = articlesDao;
    }

    public long add(List<Article> articles) throws DBException {
        //Filter articles that have Author. The Articles that doesn't have Author will be omitted
        List<Article> filteredArticles = articles.stream()
                .filter(e -> e.getAuthor() != null)
                .collect(Collectors.toList());
        logger.trace(articles.size() - filteredArticles.size() + " articles removed from list");

        long addCount = articlesDao.add(filteredArticles);
        logger.trace("Added " + addCount + " articles from " + filteredArticles.size());
        return addCount;
    }

    public List<Article> get(int limit) throws DBException {
        return articlesDao.get(limit);
    }

}
