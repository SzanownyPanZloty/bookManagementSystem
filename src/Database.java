import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
  public static Connection getConnection() {
    Connection conn = null;
    try {
      String CONNECTION_URL = "jdbc:sqlite:" + System.getProperty("user.dir") + "/bookDatabase.db";
      conn = DriverManager.getConnection(CONNECTION_URL);
    } catch (SQLException ex) {
      System.out.println("Connecting with database failed.");
    }
    return conn;
  }
}
