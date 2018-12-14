package net.sf.vgrs.gamesys.dao;

import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {

    @Autowired
    public DataSource dataSource;

    public Connection con;
    public PreparedStatement ps;
    public ResultSet rs;


    public Connection openConnection() throws SQLException {
        if (con == null || con.isClosed()){
            con = dataSource.getConnection();
        }
        return con;
    }

    public ResultSet executeQuery() throws SQLException {
        rs = ps.executeQuery();
        return rs;
    }

    public void commit(){
        try {
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
