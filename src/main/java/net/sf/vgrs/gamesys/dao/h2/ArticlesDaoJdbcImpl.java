package net.sf.vgrs.gamesys.dao.h2;

import net.sf.vgrs.gamesys.dao.ArticlesDao;
import net.sf.vgrs.gamesys.dao.BaseDao;
import net.sf.vgrs.gamesys.dao.JdbcConnectionManager;
import net.sf.vgrs.gamesys.domain.Article;
import net.sf.vgrs.gamesys.domain.exceptions.DBException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.sql.BatchUpdateException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static net.sf.vgrs.gamesys.dao.h2.SqlConstants.*;

@Repository("dao-h2-jdbc")
public class ArticlesDaoJdbcImpl extends BaseDao implements ArticlesDao {

    Logger logger = LoggerFactory.getLogger(ArticlesDaoJdbcTemplateImpl.class);

    public ArticlesDaoJdbcImpl(JdbcConnectionManager jdbcConnectionManager1) {
        super(jdbcConnectionManager1);
    }

    @Override
    public void add(Article article) {
        //todo Implement do add single article
    }

    /**
     * Method for adding articles to database. Methods provides bulk insert.
     *
     * @param articles list of articles to be added to database
     * @return Number of added rows
     */
    @Override
    public long add(List<Article> articles) throws DBException {
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
            int[] ints = jdbcConnectionManager.executeBatch();
            jdbcConnectionManager.commit();
            return Arrays.stream(ints).sum();
        } catch (BatchUpdateException b) {
            if (H2SQLStates.DUPLICATE_KEY_1.value.equals(b.getSQLState())) {
                int[] updateCounts = b.getUpdateCounts();
                long count = Arrays.stream(updateCounts).filter(i -> i == 1).count();
                logger.info("Duplicate key error occurred during batch inset. Added " + count + " of " + articles.size());
                return count;
            } else {
                logger.info("BatchUpdateException occurred during batch inset", b);
            }
            throw new DBException(b);
        } catch (SQLException e) {
            logger.error("SQLException occurred during batch inset", e);
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
    public List<Article> get(long rowCount) throws DBException {
        try {
            List<Article> articles = new ArrayList<>();
            jdbcConnectionManager.openConnection();
            jdbcConnectionManager.prepareStatement(SELECT_ARTICLES, ps -> {
                ps.setLong(1, rowCount);
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
            return articles;
        } catch (SQLException e) {
            logger.error("SQLException occurred during getting data from database", e);
            throw new DBException(e);
        }
    }

    @Override
    public void delete() throws DBException {
        try {
            jdbcConnectionManager.openConnection();
            jdbcConnectionManager.prepareStatement(DELETE_ARTICLES, ps -> { });
            jdbcConnectionManager.execute();
            jdbcConnectionManager.commit();
        } catch (SQLException e) {
            logger.error("SQLException occurred during getting data from database", e);
            throw new DBException(e);
        }
    }
}