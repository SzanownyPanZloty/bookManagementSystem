# 1. Book Management System

Book management system is a simple **Java** application where you can fetch, add and delete books. **JavaFX** library GUI allows you to interact with data stored in **MySQL** database.

## Table of Contents
- [1. Book Management System](#1-book-management-system)
  - [Table of Contents](#table-of-contents)
  - [Features](#features)
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


## Java Libraries used
- **JavaFX**: Used for creating the graphical user interface of the application.
- **MySQL Connector**: Used for connecting the Java application to the MySQL database.


## How to run the project

### Prerequisites

- Java 21 *(Older versions were not tested)*
- Appache Maven

[Click this link if you need help with instaling Maven](https://maven.apache.org/install.html). If You have Maven installed, follow these steps:

### Instalation

**1. Clone git repository**
```bash
git clone https://github.com/SzanownyPanZloty/bookManagementSystem.git
```

**2. Execute `Database.sql` on your MySQL Server**

**3. Edit `Database.java` file**
```java
String url = "jdbc:mysql://localhost:3306/YOUR_DATABASE_NAME"; //booksDB if you didn't change Database.sql file
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