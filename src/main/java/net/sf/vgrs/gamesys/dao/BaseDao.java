package net.sf.vgrs.gamesys.dao;

public abstract class BaseDao {

    public final JdbcConnectionManager jdbcConnectionManager;

    public BaseDao(JdbcConnectionManager jdbcConnectionManager1) {

        this.jdbcConnectionManager = jdbcConnectionManager1;
    }

}
