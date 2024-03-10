package com.jz;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

    fetchBooks();

    bookSearch.textProperty().addListener((observable, oldValue, newValue) -> {
      filteredBooksList.setPredicate(book -> {
        if (newValue == null || newValue.isEmpty())
          return true;
        String properties[] = { book.getName(), book.getAuthor(), book.getGenre(), book.getYear().toString() };
        for (String property : properties) {
          try {
            Pattern pattern = Pattern.compile(newValue, Pattern.CASE_INSENSITIVE);
            if (pattern.matcher(property).find())
              return true;
          } catch (PatternSyntaxException e) {
            if (property.toLowerCase().contains(newValue.toLowerCase()))
              return true;
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
        return false;
      });
    });

    sortedData.comparatorProperty().bind(booksTable.comparatorProperty());
    booksTable.setItems(sortedData);

  }

  private void fetchBooks() {
    try {
      booksList.clear();
      Connection con = Database.getConnection();
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
        booksList.add(book);
      }
      con.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private Boolean addBook() {
    String sql = "INSERT INTO books (bookName, bookAuthor, bookGenre, bookYear, bookDescription) VALUES (?, ?, ?, ?,?)";
    try (Connection con = Database.getConnection(); PreparedStatement statement = con.prepareStatement(sql)) {
      statement.setString(1, newBookName.getText());
      statement.setString(2, newBookAuthor.getText());
      statement.setString(3, newBookGenre.getText());
      statement.setInt(4, Integer.parseInt(newBookYear.getText()));
      statement.setString(5, newBookDescription.getText());
      int rowsInserted = statement.executeUpdate();
      if (rowsInserted > 0) {
        statusLabel.setText("A new book was added successfully!");
        fetchBooks();
        return true;
      }
      con.close();
      return false;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    } catch (Exception e) {
      return false;
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
    // TODO add field type check
    for (TextField field : fields) {
      if (field.getText().isBlank()) {
        return;
      }
    }
    addBook();
    for (TextField field : fields) {
      field.setText("");
    }
  }

  @FXML
  void onDeleteBook(ActionEvent event) {
    if (booksTable.getSelectionModel().selectedItemProperty().isNull() == null)
      return;
    String sql = "DELETE FROM books WHERE bookId = ?";
    try (Connection con = Database.getConnection(); PreparedStatement statement = con.prepareStatement(sql)) {
      statement.setString(1, String.valueOf(booksTable.getSelectionModel().getSelectedItem().getId()));
      int rowsInserted = statement.executeUpdate();
      if (rowsInserted > 0) {
        fetchBooks();
        return;
      }
      con.close();
      return;
    } catch (SQLException e) {
      e.printStackTrace();
      return;
    } catch (Exception e) {
      return;
    }
  }

  @FXML
  void onViewBook(ActionEvent event) throws IOException {
    if (booksTable.getSelectionModel().selectedItemProperty().isNull() == null)
      return;
    Context.getInstance().setSelectedBookId(booksTable.getSelectionModel().getSelectedItem().getId());
    App.setRoot("ViewBook");
  }
}
