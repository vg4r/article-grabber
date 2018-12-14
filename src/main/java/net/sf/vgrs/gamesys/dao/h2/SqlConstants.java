package net.sf.vgrs.gamesys.dao.h2;

public class SqlConstants {


    public static final String INSERT_ARTICLES = "INSERT INTO articles(url, author, title, description, published_at, content) VALUES (?,?,?,?,?,?)";

    public static final String SELECT_ARTICLES = "SELECT url, author, title, description, published_at, content FROM articles order by published_at desc limit ?";
}
