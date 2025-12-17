package com.lms.gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookService {

    private static final String URL =
        "jdbc:mysql://localhost:3306/lms?useSSL=false&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public BookService() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    // Fetch all books from DB
    public ResultSet getAllBooks() throws SQLException {
        Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        Statement st = con.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY
        );
        return st.executeQuery("SELECT * FROM book");
    }
}
