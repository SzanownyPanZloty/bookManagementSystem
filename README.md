# 1. Book Management System

Book management system is a simple **Java** application where you can fetch, add and delete books. **JavaFX** library GUI allows you to interact with data stored in **MySQL** database.

## Table of Contents
- [1. Book Management System](#1-book-management-system)
  - [Table of Contents](#table-of-contents)
  - [Features](#features)
  - [Libraries used](#libraries-used)
  - [Instalation](#instalation)

## Features

- Search for books using words and **regular expressions**.
- Sort books based on various criteria **(e.g., title, author, publication year, genre)**.
- Add books using menu on left side.
- Remove books by right clicking and selecting `Remove book`.
- Display information about books by right clicking and selecting `View book`.

## Libraries used
- JavaFX
- MySQL Connector

## Instalation

In order to run this project you need **Appache Maven** to be installed on your computer ([Click this link if you need help with instaling Maven](https://maven.apache.org/install.html)). If Maven is installed follow these steps:

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


**4. Compile dependencies**
```bash
mvn clean install
```
Maven is going to install all [external libraries](#libraries-used) for you

**5. Run the program**
```bash
mvn clean javafx:run
```