package net.sf.vgrs.gamesys.dao;

import net.sf.vgrs.gamesys.domain.Article;
import net.sf.vgrs.gamesys.domain.exceptions.DBException;

import java.util.List;

public interface ArticlesDao {

    long add(List<Article> articles) throws DBException;

    void add(Article article);

    List<Article> get(long rowCount) throws DBException;

    void delete() throws DBException;

}
