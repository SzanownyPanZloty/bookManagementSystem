import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class AppController {

  ObservableList<Book> booksList = FXCollections.observableArrayList();

  @FXML
  private TextField bookAuthorField;

  @FXML
  private TextField bookGenreField;

  @FXML
  private TextField bookNameField;

  @FXML
  private TextField bookSearch;

  @FXML
  private TextField bookYearField;

  @FXML
  private TableColumn<Book, Integer> bookIdColumn;

  @FXML
  private TableColumn<Book, String> bookNameColumn;

  @FXML
  private TableColumn<Book, String> bookAuthorColumn;

  @FXML
  private TableColumn<Book, Integer> bookYearOfReleaseColumn;

  @FXML
  private TableColumn<Book, String> bookGenreColumn;

  @FXML
  private TableView<Book> booksTable;

  @FXML
  void addBookButtonClicked(ActionEvent event) throws SQLException {
    populateTable();
  }

  public void initialize() {

    bookIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
    bookNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
    bookAuthorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
    bookGenreColumn.setCellValueFactory(new PropertyValueFactory<>("genre"));
    bookYearOfReleaseColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
    populateTable();
    bookSearch.textProperty().addListener((obs, oldText, newText) -> {
      search();
    });
  }

  private void populateTable() {
    try {
      Connection con = Database.getConnection();
      Statement st = con.createStatement();
      String sql = "SELECT * FROM books";
      ResultSet res = st.executeQuery(sql);
      while (res.next()) {
        // Create Book object for each row and add it to the list
        Book book = new Book(
            res.getInt("bookId"),
            res.getString("bookName"),
            res.getString("bookAuthor"),
            res.getString("bookGenre"),
            res.getInt("bookYearOfRelease"));
        booksList.add(book);
      }
      // Set items in the table
      booksTable.setItems(booksList);
      con.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @FXML
  private void search() {
    String keyword = bookSearch.getText();
    if (keyword.equals("")) {
      booksTable.setItems(booksList);
    } else {
      ObservableList<Book> filteredData = FXCollections.observableArrayList();
      for (Book book : booksList) {
        String properties[] = {
            book.getName(),
            book.getAuthor(),
            book.getGenre(),
            String.valueOf(book.getId()),
            String.valueOf(book.getYear())
        };
        for (String property : properties) {
          if (property.toLowerCase().contains(keyword.toLowerCase())) {
            filteredData.add(book);
            break;
          }
        }
      }
      booksTable.setItems(filteredData);
    }
  }

}