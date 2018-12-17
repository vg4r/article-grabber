package net.sf.vgrs.gamesys.dao.jdbc;

import net.sf.vgrs.gamesys.dao.ArticlesDao;
import net.sf.vgrs.gamesys.domain.Article;
import net.sf.vgrs.gamesys.domain.exceptions.DBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static net.sf.vgrs.gamesys.dao.jdbc.SqlConstants.INSERT_ARTICLES;

@Repository("dao-jdbcTemplate")
public class ArticlesDaoJdbcTemplateImpl implements ArticlesDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void add(Article article) {
        //todo Implement do add single article
    }

    @Override
    public long add(List<Article> articles) {
        try {
            //todo fix bug in JdbcTemplate batchUpdate. There is bug that, it throws exception even if no duplicate elements
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


    @Override
    public List<Article> get(long rowCount) {
        //todo Implement get article list via JdbcTemplate
        return null;
    }

    @Override
    public void delete() throws DBException {
        //todo Implement get article list via JdbcTemplate
    }

}