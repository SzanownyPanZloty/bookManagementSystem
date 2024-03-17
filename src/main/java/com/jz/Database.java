package com.jz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Database {

  static String url = "jdbc:mysql://localhost:3306/booksDB";
  static String username = "root";
  static String password = "root";

  private static Connection getConnection() {
    Connection con = null;
    try {
      con = DriverManager.getConnection(url, username, password);
    } catch (SQLException e) {
      System.out.println("Connecting with database failed.");
    }
    if (con == null)
      throw new RuntimeException("Database connection failed.");
    return con;
  }

  public static List<Book> fetchBooks() {
    Connection con = Database.getConnection();
    List<Book> books = new ArrayList<>();
    try {
      Statement st = con.createStatement();
      String sql = "SELECT * FROM books";
      ResultSet res = st.executeQuery(sql);
      while (res.next()) {
        Book book = new Book(
            res.getInt("bookId"),
            res.getString("bookName"),
            res.getString("bookAuthor"),
            res.getString("bookGenre"),
            res.getInt("bookYear"),
            res.getString("bookDescription"));
        books.add(book);
      }
      con.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return books;
  }

  public static Book fetchBook(Integer bookId) {
    Connection con = Database.getConnection();
    String sql = "SELECT * FROM books WHERE bookId = ?";
    try {
      PreparedStatement statement = con.prepareStatement(sql);
      statement.setString(1, bookId.toString());
      ResultSet res = statement.executeQuery();
      res.next();
      Book book = new Book(
          res.getInt("bookId"),
          res.getString("bookName"),
          res.getString("bookAuthor"),
          res.getString("bookGenre"),
          res.getInt("bookYear"),
          res.getString("bookDescription"));
      con.close();
      return book;
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    } catch (Exception e) {
      return null;
    }
  }

  public static boolean addBook(String bookName, String bookAuthor, String bookGenre, Integer bookYear,
      String bookDescription) {
    Connection con = getConnection();
    String sql = "INSERT INTO books (bookName, bookAuthor, bookGenre, bookYear, bookDescription) VALUES (?, ?, ?, ?,?)";
    try {
      PreparedStatement statement = con.prepareStatement(sql);
      statement.setString(1, bookName);
      statement.setString(2, bookAuthor);
      statement.setString(3, bookGenre);
      statement.setInt(4, bookYear);
      statement.setString(5, bookDescription);
      int rowsInserted = statement.executeUpdate();
      con.close();
      if (rowsInserted > 0) {
        return true;
      }
      return false;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    } catch (Exception e) {
      return false;
    }
  }

  public static boolean deleteBook(Integer bookId) {
    Connection con = getConnection();
    String sql = "DELETE FROM books WHERE bookId = ?";
    try {
      PreparedStatement statement = con.prepareStatement(sql);
      statement.setInt(1, bookId);
      int rowsDeleted = statement.executeUpdate();
      con.close();
      if (rowsDeleted > 0) {
        return true;
      }
      return false;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    } catch (Exception e) {
      return false;
    }
  }

}
