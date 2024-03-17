package com.jz;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class AppController {

  ObservableList<Book> booksList = FXCollections.observableArrayList();
  FilteredList<Book> filteredBooksList = new FilteredList<>(booksList, b -> true);
  SortedList<Book> sortedData = new SortedList<>(filteredBooksList);

  @FXML
  private TableColumn<Book, String> bookAuthorColumn;

  @FXML
  private TableColumn<Book, String> bookGenreColumn;

  @FXML
  private TableColumn<Book, Integer> bookIdColumn;

  @FXML
  private TableColumn<Book, String> bookNameColumn;

  @FXML
  private TextField bookSearch;

  @FXML
  private TableColumn<Book, Integer> bookYearColumn;

  @FXML
  private TableView<Book> booksTable;

  @FXML
  private TextField newBookAuthor;

  @FXML
  private TextField newBookGenre;

  @FXML
  private TextField newBookName;

  @FXML
  private TextField newBookYear;

  @FXML
  private TextField newBookDescription;

  @FXML
  private Label statusLabel;

  public void initialize() {
    bookIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
    bookNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
    bookAuthorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
    bookGenreColumn.setCellValueFactory(new PropertyValueFactory<>("genre"));
    bookYearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));

    updateBooks();

    bookSearch.textProperty().addListener((observable, oldValue, newValue) -> {
      filteredBooksList.setPredicate(book -> {
        if (newValue == null || newValue.isEmpty())
          return true;

        // all boook properties without description because it's not displayed in any
        // column
        String properties[] = { book.getId().toString(), book.getName(), book.getAuthor(), book.getGenre(),
            book.getYear().toString() };

        // check if property matches search string
        for (String property : properties) {

          try {
            // presume that search field is valid regex
            Pattern pattern = Pattern.compile(newValue, Pattern.CASE_INSENSITIVE);
            if (pattern.matcher(property).find())
              return true;
          } catch (PatternSyntaxException e) {
            // if the search string is not regex
            if (property.toLowerCase().contains(newValue.toLowerCase()))
              return true;
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
        return false;
      });
    });

    // make filtered list sortable using table columns
    sortedData.comparatorProperty().bind(booksTable.comparatorProperty());

    booksTable.setItems(sortedData);

  }

  /**
   * Fetches books from the database and updates the booksList.
   */
  private void updateBooks() {
    try {
      booksList.clear();
      List<Book> books = Database.fetchBooks();
      for (Book book : books) {
        booksList.add(book);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Changes the status label text and style.
   * 
   * @param success if the operation was successful
   * @param message the message to display
   */
  private void changeStatusLabel(Boolean success, String message) {
    statusLabel.getStyleClass().remove("success");
    statusLabel.getStyleClass().remove("danger");
    if (success) {
      statusLabel.getStyleClass().add("success");
    } else {
      statusLabel.getStyleClass().add("danger");
    }
    statusLabel.setText(message);
  }

  /**
   * Adds a new book to the database.
   */
  private void addBook() {

    boolean handler = Database.addBook(
        newBookName.getText(),
        newBookAuthor.getText(),
        newBookGenre.getText(),
        Integer.parseInt(newBookYear.getText()),
        newBookDescription.getText());

    if (handler) {
      changeStatusLabel(true, "A new book was added successfully!");
      updateBooks();
      return;
    } else {
      changeStatusLabel(false, "An error occurred while adding a new book.");
    }
  }

  @FXML
  void addBookButtonClicked(ActionEvent event) {
    TextField fields[] = {
        newBookName,
        newBookAuthor,
        newBookGenre,
        newBookYear,
        newBookDescription
    };

    // check if any field is empty
    for (TextField field : fields) {
      if (field.getText().isBlank()) {
        changeStatusLabel(false, "All fields are required.");
        return;
      }
    }

    // check if yearField is not a number
    try {
      Integer.parseInt(newBookYear.getText());
    } catch (NumberFormatException ex) {
      changeStatusLabel(false, "Year must be a number.");
      return;
    }

    addBook();

    // clear all fields
    for (TextField field : fields) {
      field.setText("");
    }
  }

  @FXML
  void onDeleteBook(ActionEvent event) {
    if (booksTable.getSelectionModel().selectedItemProperty().isNull() == null)
      return;
    Book selectedBook = booksTable.getSelectionModel().getSelectedItem();
    try {
      Boolean handler = Database.deleteBook(selectedBook.getId());
      if (!handler) {
        changeStatusLabel(false, "An error occurred while deleting the book.");
        return;
      }
      changeStatusLabel(true, "Book was deleted successfully!");
      updateBooks();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @FXML
  void onViewBook(ActionEvent event) throws IOException {
    if (booksTable.getSelectionModel().selectedItemProperty().isNull() == null)
      return;
    Book selectedBook = booksTable.getSelectionModel().getSelectedItem();
    Context.getInstance().setSelectedBookId(selectedBook.getId());
    App.setRoot("ViewBook");
  }
}