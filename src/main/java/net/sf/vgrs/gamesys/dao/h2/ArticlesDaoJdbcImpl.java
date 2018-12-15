package net.sf.vgrs.gamesys.dao.h2;

import net.sf.vgrs.gamesys.dao.ArticlesDao;
import net.sf.vgrs.gamesys.dao.BaseDao;
import net.sf.vgrs.gamesys.dao.JdbcConnectionManager;
import net.sf.vgrs.gamesys.domain.Article;
import net.sf.vgrs.gamesys.domain.exceptions.DBException;
import net.sf.vgrs.gamesys.domain.exceptions.DuplicateElementException;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static net.sf.vgrs.gamesys.dao.h2.SqlConstants.INSERT_ARTICLES;
import static net.sf.vgrs.gamesys.dao.h2.SqlConstants.SELECT_ARTICLES;

@Repository("dao-h2-jdbc")
public class ArticlesDaoJdbcImpl extends BaseDao implements ArticlesDao {


    public ArticlesDaoJdbcImpl(JdbcConnectionManager jdbcConnectionManager1) {
        super(jdbcConnectionManager1);
    }

    @Override
    public void add(Article article) {

    }

    /**
     * Method for adding articles to database. Methods provides bulk insert.
     *
     * @param articles list of articles to be added to database
     * @return
     */
    @Override
    public void add(List<Article> articles) throws DBException {
        try {
            jdbcConnectionManager.openConnection();
            jdbcConnectionManager.prepareStatement(INSERT_ARTICLES, ps -> {
                for (Article entry : articles) {
                    ps.setString(1, entry.getUrl());
                    ps.setString(2, entry.getAuthor());
                    ps.setString(3, entry.getTitle());
                    ps.setString(4, entry.getDescription());
                    ps.setDate(5, new java.sql.Date(entry.getPublishedDate().getTime()));
                    ps.setString(6, entry.getContent());
                    ps.addBatch();
                }
            });
        } catch (BatchUpdateException b) {
            if (H2SQLStates.DUPLICATE_KEY_1.value.equals(b.getSQLState())) {
                throw new DuplicateElementException();
            }
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    /**
     * Method for articles users from database.
     *
     * @param rowCount defines how many last rows ro return
     * @return list of Article objects. in case of no articles in database it will return empty list
     */
    @Override
    public List<Article> get(int rowCount) throws DBException {
        List<Article> articles = new ArrayList<>();
        try {
            jdbcConnectionManager.openConnection();
            jdbcConnectionManager.prepareStatement(SELECT_ARTICLES, ps -> {
                ps.setInt(1, rowCount);
            });
            jdbcConnectionManager.executeQuery(rs -> {
                while (rs.next()) {
                    Article article = new Article();
                    article.setUrl(rs.getString("url"));
                    article.setAuthor(rs.getString("author"));
                    article.setTitle(rs.getString("title"));
                    article.setDescription(rs.getString("description"));
                    article.setPublishedDate(rs.getDate("published_at"));
                    article.setContent(rs.getString("content"));
                    articles.add(article);
                }
            });
        } catch (SQLException e) {
            throw new DBException(e);
        }
        return articles;
    }
}