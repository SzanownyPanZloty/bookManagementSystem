package com.jz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
  public static Connection getConnection() {
    Connection conn = null;

    String url = "jdbc:mysql://localhost:3306/booksDB";
    String username = "root";
    String password = "root";

    try {
      conn = DriverManager.getConnection(url, username, password);
    } catch (SQLException ex) {
      System.out.println("Connecting with database failed.");
    }
    return conn;
  }
}
