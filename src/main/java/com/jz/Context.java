package com.jz;

public class Context {
  private final static Context instance = new Context();

  private int selectedBookId;

  public static Context getInstance() {
    return instance;
  }

  public int getSelectedBookId() {
    return this.selectedBookId;
  }

  public void setSelectedBookId(int selectedBookId) {
    this.selectedBookId = selectedBookId;
  }

}