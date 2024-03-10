package com.jz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
  public static Connection getConnection() {
    Connection con = null;

    String url = "jdbc:mysql://localhost:3306/booksDB";
    String username = "root";
    String password = "root";

    try {
      con = DriverManager.getConnection(url, username, password);
    } catch (SQLException e) {
      System.out.println("Connecting with database failed.");
    }
    return con;
  }
}
