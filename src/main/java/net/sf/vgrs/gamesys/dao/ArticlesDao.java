package net.sf.vgrs.gamesys.dao;

import net.sf.vgrs.gamesys.domain.Article;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticlesDao  {

    public void add(List<Article> articles);
    public void add(Article article);
    public List<Article> get(int rowCount);

}
