public class Book {
  private Integer id;
  private String name;
  private String author;
  private String genre;
  private Integer year;

  // Constructor
  public Book(Integer id, String name, String author, String genre, Integer year) {
      this.id = id;
      this.name = name;
      this.author = author;
      this.genre = genre;
      this.year = year;
  }

  // Getters and setters
  public Integer getId() {
      return id;
  }

  public void setId(Integer id) {
      this.id = id;
  }

  public String getName() {
      return name;
  }

  public void setName(String name) {
      this.name = name;
  }

  public String getAuthor() {
      return author;
  }

  public void setAuthor(String author) {
      this.author = author;
  }

  public String getGenre() {
      return genre;
  }

  public void setGenre(String genre) {
      this.genre = genre;
  }

  public Integer getYear() {
      return year;
  }

  public void setYear(Integer year) {
      this.year = year;
  }
}
