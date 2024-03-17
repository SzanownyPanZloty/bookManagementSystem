package com.jz;

public class Book {
  private Integer id;
  private String name;
  private String author;
  private String genre;
  private Integer year;
  private String description;

  public Book(Integer id, String name, String author, String genre, Integer year, String description) {
    this.id = id;
    this.name = name;
    this.author = author;
    this.genre = genre;
    this.year = year;
    this.description = description;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAuthor() {
    return this.author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getGenre() {
    return this.genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public Integer getYear() {
    return this.year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public String getDescription() {
    return this.description;
  }

  public void setdescription(String description) {
    this.description = description;
  }

}
