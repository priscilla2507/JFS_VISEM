import java.sql.*;
import java.util.Scanner;

public class BookIssuedInsert {
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

            // Read bookissued details
            System.out.print("Enter Issue ID: ");
            int issueID = sc.nextInt();
            sc.nextLine(); // consume newline

            System.out.print("Enter ISBN: ");
            String isbn = sc.nextLine();

            System.out.print("Enter Book Name: ");
            String bookName = sc.nextLine();

            System.out.print("Enter RegID: ");
            int regID = sc.nextInt();
            sc.nextLine(); // consume newline

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Reserve Date (YYYY-MM-DD): ");
            String reserveDate = sc.nextLine();

            System.out.print("Enter Issue Date (YYYY-MM-DD): ");
            String issueDate = sc.nextLine();

            System.out.print("Enter Renewal Date (YYYY-MM-DD): ");
            String renewalDate = sc.nextLine();

            System.out.print("Enter Returned Date (YYYY-MM-DD): ");
            String returnedDate = sc.nextLine();

            System.out.print("Enter Status: ");
            String status = sc.nextLine();

            // SQL Insert Query
            String sql = "INSERT INTO bookissued (issueID, isbn, bookName, regID, name, reserveDate, issueDate, renewalDate, returnedDate, status) " +
                         "VALUES (" + issueID + ", '" + isbn + "', '" + bookName + "', " + regID + ", '" + name + "', '" +
                         reserveDate + "', '" + issueDate + "', '" + renewalDate + "', '" + returnedDate + "', '" + status + "')";

            // Execute statement
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);
            System.out.println("Inserted into bookissued table successfully");

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

