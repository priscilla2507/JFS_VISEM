package com.lms.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LMSDatabaseService {

    private static final String URL =
        "jdbc:mysql://localhost:3306/lms?useSSL=false&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public LMSDatabaseService() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    /**
     * Authenticate user using regID OR email and password
     * @param identifier  regID (number) OR email (string)
     * @param password    password
     * @return roleName if success, null if failed
     */
    public String authenticateUser(int regID, String password) {

    String sql =
        "SELECT roleName FROM register " +
        "WHERE regID = ? AND pass = ?";

    try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, regID);
        ps.setString(2, password.trim().toLowerCase());

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return rs.getString("roleName");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}
public void registerUser(int regID,
                         String name,
                         String email,
                         String pass,
                         String mobile,
                         String address,
                         String roleName) {

    String sql = "INSERT INTO register VALUES (?,?,?,?,?,?,?)";

    try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, regID);
        ps.setString(2, name);
        ps.setString(3, email);
        ps.setString(4, pass);
        ps.setString(5, mobile);
        ps.setString(6, address);
        ps.setString(7, roleName);

        ps.executeUpdate();

    } catch (Exception e) {
        e.printStackTrace();
    }
}
public void addBook(int isbn,
                    String bookName,
                    String author,
                    double price,
                    String publisher,
                    int publishingYear,
                    int qtyAvailable) {

    String sql = "INSERT INTO book VALUES (?,?,?,?,?,?,?)";

    try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
         PreparedStatement ps = con.prepareStatement(sql)) {

        System.out.println("CONNECTED TO DB: " + con.getCatalog());
        System.out.println("INSERTING BOOK: " + bookName);

        ps.setInt(1, isbn);
        ps.setString(2, bookName);
        ps.setString(3, author);
        ps.setDouble(4, price);
        ps.setString(5, publisher);
        ps.setInt(6, publishingYear);
        ps.setInt(7, qtyAvailable);

        int rows = ps.executeUpdate();
        System.out.println("ROWS INSERTED = " + rows);

    } catch (Exception e) {
        e.printStackTrace();
    }
}
public void issueBook(int issueID,
                      int isbn,
                      String bookName,
                      int regID,
                      String name,
                      Date reserveDate,
                      Date issueDate,
                      Date renewalDate,
                      Date returnedDate,
                      String status) {

    String sql = "INSERT INTO bookissued VALUES (?,?,?,?,?,?,?,?,?,?)";

    try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, issueID);
        ps.setInt(2, isbn);
        ps.setString(3, bookName);
        ps.setInt(4, regID);
        ps.setString(5, name);
        ps.setDate(6, reserveDate);
        ps.setDate(7, issueDate);
        ps.setDate(8, renewalDate);
        ps.setDate(9, returnedDate);
        ps.setString(10, status);

        ps.executeUpdate();

    } catch (Exception e) {
        e.printStackTrace();
    }
}


}
