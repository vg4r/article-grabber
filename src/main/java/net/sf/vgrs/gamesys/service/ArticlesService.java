package net.sf.vgrs.gamesys.service;

import net.sf.vgrs.gamesys.dao.ArticlesDao;
import net.sf.vgrs.gamesys.dao.JdbcConnectionManager;
import net.sf.vgrs.gamesys.domain.Article;
import net.sf.vgrs.gamesys.domain.exceptions.DBException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticlesService {

    private final JdbcConnectionManager connectionManager;
    private final ArticlesDao articlesDao;

    public ArticlesService(JdbcConnectionManager connectionManager, @Qualifier("dbProvider") ArticlesDao articlesDao) {
        this.connectionManager = connectionManager;
        this.articlesDao = articlesDao;
    }

    public long add(List<Article> articles) throws DBException {
        return articlesDao.add(articles);
    }

    public List<Article> get(int limit) throws DBException {
        return articlesDao.get(limit);
    }

}
