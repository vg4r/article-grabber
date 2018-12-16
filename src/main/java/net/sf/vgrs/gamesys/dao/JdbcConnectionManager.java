package net.sf.vgrs.gamesys.dao;

import net.sf.vgrs.gamesys.domain.exceptions.DBException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class JdbcConnectionManager implements Closeable {

    private final DataSource dataSource;
    Logger logger = LoggerFactory.getLogger(JdbcConnectionManager.class);
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    public JdbcConnectionManager(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void openConnection() throws SQLException {
        if (con == null || con.isClosed()) {
            logger.trace("Opened connection to database");
            con = dataSource.getConnection();
        }
    }

    public void commit() {
        if (con != null) {
            try {
                con.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void rollback() {
        if (con != null) {
            try {
                con.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void prepareStatement(String query, PreparedStatementWrapper psWrapper) throws SQLException {
        ps = con.prepareStatement(query);
        psWrapper.ps(ps);
    }

    public void resultSet(ResultSetWrapper rsWrapper) throws SQLException {
        rsWrapper.rs(rs);
    }

    public int[] executeBatch() throws SQLException {
        return ps.executeBatch();
    }

    public boolean execute() throws SQLException {
        return ps.execute();
    }

    public void executeQuery(ResultSetWrapper rsWrapper) throws SQLException {
        rs = ps.executeQuery();
        rsWrapper.rs(rs);
    }

    @Override
    public void close() throws IOException {
        try {
            closeConnection();
        } catch (DBException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() throws DBException {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            throw new DBException(e);
        }
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            throw new DBException(e);
        }

        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    @FunctionalInterface
    public interface PreparedStatementWrapper {
        public void ps(PreparedStatement ps) throws SQLException;
    }

    @FunctionalInterface
    public interface ResultSetWrapper {
        public void rs(ResultSet rs) throws SQLException;
    }
}
