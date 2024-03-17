package com.jz;

import java.io.IOException;
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
    try {
      Book book = Database.fetchBook(Context.getInstance().getSelectedBookId());
      bookName.setText(book.getName());
      bookDescription.setText(book.getDescription());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
