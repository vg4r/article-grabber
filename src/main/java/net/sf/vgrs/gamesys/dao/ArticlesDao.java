package net.sf.vgrs.gamesys.dao;

import net.sf.vgrs.gamesys.domain.Article;
import net.sf.vgrs.gamesys.domain.exceptions.DBException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticlesDao  {

    public long add(List<Article> articles) throws DBException;

    public void add(Article article);

    public List<Article> get(long rowCount) throws DBException;

    public void delete() throws DBException;

}
