package net.sf.vgrs.gamesys.dao.h2;

import net.sf.vgrs.gamesys.dao.ArticlesDao;
import net.sf.vgrs.gamesys.domain.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static net.sf.vgrs.gamesys.dao.h2.SqlConstants.INSERT_ARTICLES;

@Repository("dao-jdbcTemplate")
public class ArticlesDaoJdbcTemplateImpl implements ArticlesDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void add(Article article){

    }

    @Override
    public void add(List<Article> articles){
        try{
            int[] ints = jdbcTemplate.batchUpdate(INSERT_ARTICLES, new BatchPreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Article entry = articles.get(i);
                    ps.setString(1, entry.getUrl());
                    ps.setString(2, entry.getAuthor());
                    ps.setString(3, entry.getTitle());
                    ps.setString(4, entry.getDescription());
                    ps.setDate(5, new java.sql.Date(entry.getPublishedDate().getTime()));
                    ps.setString(6, entry.getContent());
                    ps.addBatch();
                }

                @Override
                public int getBatchSize() {
                    return articles.size();
                }
            });
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public List<Article> get(int rowCount){
        return null;
    }

}