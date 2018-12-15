package net.sf.vgrs.gamesys.dao;

import net.sf.vgrs.gamesys.domain.Article;
import net.sf.vgrs.gamesys.domain.exceptions.DBException;
import net.sf.vgrs.gamesys.domain.exceptions.DuplicateElementException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticlesDao  {

    public void add(List<Article> articles) throws DBException;
    public void add(Article article);
    public List<Article> get(int rowCount) throws DBException;

}
