package net.sf.vgrs.gamesys.utils;

import javax.sql.DataSource;
import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtility implements Closeable {

    private DataSource dataSource;

    public Connection con;
    public PreparedStatement ps;
    public ResultSet rs;



    private JdbcUtility(DataSource dataSource){
        this.dataSource = dataSource;
    }


    public static JdbcUtility getInstance(DataSource dataSource){
        return new JdbcUtility(dataSource);
    }

    public void openConnection() throws SQLException {
        con = dataSource.getConnection();
    }

    @Override
    public void close() throws IOException {
        try {
            if (rs != null )rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (ps!= null) ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (con!= null && !con.isClosed() ){
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
