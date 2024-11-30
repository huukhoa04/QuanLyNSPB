package com.quanlynspb.models.data;

import java.sql.*;

public class QuanLyNspbDb {
    String driverName = "com.mysql.cj.jdbc.Driver";
    String dbUrl = "jdbc:mysql://localhost:3306/dulieu";
    String dbUser = "root";
    String dbPassword = "";
    Connection conn = null;
    Statement stmt = null;
    public void ConnectToDb() throws SQLException, ClassNotFoundException {
        Class.forName(driverName);
        conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
//        System.out.println("Connected to database");
    }
    public QuanLyNspbDb() throws SQLException, ClassNotFoundException {
        ConnectToDb();
    }
    public ResultSet executeQuery(String sql) throws SQLException {
        stmt = conn.createStatement();
        return stmt.executeQuery(sql);
    }
    public int executeUpdate(String sql) throws SQLException {
        stmt = conn.createStatement();
        return stmt.executeUpdate(sql);
    }
    public boolean execute(String sql) throws SQLException {
        stmt = conn.prepareStatement(sql);
        return stmt.execute(sql);
    }
}
