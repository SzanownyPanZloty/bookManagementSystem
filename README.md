# 1. Book Management System
Book management system is a simple **Java** application where you can display, add and delete books. **JavaFX** library GUI allows you to interact with data stored in **MySQL** database.

## Table of Contents
- [1. Book Management System](#1-book-management-system)
  - [Table of Contents](#table-of-contents)
  - [Features](#features)
  - [Images](#images)
  - [Java Libraries used](#java-libraries-used)
  - [How to run the project](#how-to-run-the-project)
    - [Prerequisites](#prerequisites)
    - [Instalation](#instalation)


## Features

- **Search for Books**: The application allows you to search for books using words and regular expressions.
- **Sort Books**: You can sort books based on various criteria such as title, author, publication year, and genre.
- **Add Books**: You can add new books to the system using a menu on the left side of the application.
- **Remove Books**: You can remove books from the system by right-clicking on a book and selecting 'Remove book'.
- **View Book Information**: You can view detailed information about a book by right-clicking on a book and selecting 'View book'.

## Images

</br>
<p align="center">
  <img src="img/app.jpg" />
  </br>
  </br>
  <img src="img/options.jpg" />
  </br>
  </br>
  <img src="img/details.jpg" />
</p>

## Java Libraries used
- **JavaFX**: Used for creating the graphical user interface of the application.
- **AtlantaFX**: Used for styling default look of JavaFX GUI.
- **MySQL Connector**: Used for connecting the Java application to the MySQL database.


## How to run the project

### Prerequisites

- Java 21 *(Older versions might work but were not tested)*
- Appache Maven
- MySQL Server

[Click this link if you need help with instaling Maven](https://maven.apache.org/install.html). If You have Maven installed, follow these steps:

### Instalation

**1. Clone git repository**
```bash
git clone https://github.com/SzanownyPanZloty/bookManagementSystem.git
```

**2. Execute `Database.sql` on your MySQL Server**
Database contains 25 randomly generated books

**3. Edit `Database.java` file**
```java
String url = "jdbc:mysql://localhost:3306/YOUR_DATABASE_NAME"; //booksDB if you did not modify `Database.sql` file
String username = "YOUR_DATABASE_USERNAME";
String password = "YOUR_DATABASE_PASSWORD";
```

**4. Build the project**
Build the project using the command:
```bash
mvn clean install
```
Maven will automatically install all the necessary external libraries for you.

**5. Run the project**
```bash
mvn clean javafx:run
```