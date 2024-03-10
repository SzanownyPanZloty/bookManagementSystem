package com.jz;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ViewBookController {

  @FXML
  private Label bookDescription;

  @FXML
  private Label bookName;

  @FXML
  void onGoBackClicked(ActionEvent event) throws IOException {
    App.setRoot("App");
  }

  public void initialize() {
    String sql = "SELECT bookName, bookDescription FROM books WHERE bookId = ?";
    try (Connection con = Database.getConnection(); PreparedStatement statement = con.prepareStatement(sql)) {
      statement.setString(1, String.valueOf(Context.getInstance().getSelectedBookId()));
      ResultSet rs = statement.executeQuery();
      rs.next();
      bookName.setText(rs.getString("bookName"));
      bookDescription.setText(rs.getString("bookDescription"));
      con.close();
      return;
    } catch (SQLException e) {
      e.printStackTrace();
      return;
    } catch (Exception e) {
      return;
    }
  }

}
