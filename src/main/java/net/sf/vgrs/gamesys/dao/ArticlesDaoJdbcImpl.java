package net.sf.vgrs.gamesys.dao;

import net.sf.vgrs.gamesys.domain.Article;
import net.sf.vgrs.gamesys.utils.JdbcUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository("dao-jdbc")
public class ArticlesDaoJdbcImpl extends JdbcDaoSupport implements ArticlesDao {

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }


    @Override
    public void add(Article article){

    }

    @Override
    public void add(List<Article> articles){
        try(JdbcUtility jdbc = JdbcUtility.getInstance(dataSource)){
            String sql =
                    "INSERT INTO articles(url, author, title, description, published_at, content) VALUES (?,?,?,?,?,?)";
            jdbc.openConnection();
            jdbc.ps = jdbc.con.prepareStatement(sql);

            for(Article entry: articles){
                System.out.println(entry.getUrl());
                jdbc.ps.setString(1, entry.getUrl());
                jdbc.ps.setString(2, entry.getAuthor());
                jdbc.ps.setString(3, entry.getTitle());
                jdbc.ps.setString(4, entry.getDescription());
                jdbc.ps.setDate(5, new java.sql.Date(entry.getPublishedDate().getTime()));
                jdbc.ps.setString(6, entry.getContent());
                jdbc.ps.addBatch();
            }
            jdbc.ps.executeBatch();
            jdbc.con.commit();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Article> get(int rowCount){
        return null;
    }

}