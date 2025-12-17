import java.sql.*;
import java.util.Scanner;

public class BookInsert {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/lms"; // Change DB name if different
        String username = "root";  // Your MySQL username
        String password = "";      // Your MySQL password

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully");

            // Establish connection
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established");

            Scanner sc = new Scanner(System.in);

            // Read book details
            System.out.print("Enter ISBN: ");
            String isbn = sc.nextLine();

            System.out.print("Enter Book Name: ");
            String bookName = sc.nextLine();

            System.out.print("Enter Author: ");
            String author = sc.nextLine();

            System.out.print("Enter Price: ");
            double price = sc.nextDouble();
            sc.nextLine(); // consume newline

            System.out.print("Enter Publisher: ");
            String publisher = sc.nextLine();

            System.out.print("Enter Publishing Year: ");
            int publishingYEAR = sc.nextInt();

            System.out.print("Enter Quantity Available: ");
            int qtyAvailable = sc.nextInt();

            // SQL Insert Query
            String sql = "INSERT INTO book (isbn, bookName, author, price, publisher, publishingYEAR, qtyAvailable) " +
                         "VALUES ('" + isbn + "', '" + bookName + "', '" + author + "', " + price + ", '" +
                         publisher + "', " + publishingYEAR + ", " + qtyAvailable + ")";

            // Execute statement
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);
            System.out.println("Inserted into book table successfully");

            // Close resources
            stmt.close();
            con.close();
            sc.close();
            System.out.println("Connection Closed");

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database error occurred.");
            e.printStackTrace();
        }
    }
}
