import java.sql.*;

public class Book{
    public static void main(String[] args) throws Exception {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/lms";
        String username = "root";
        String password = "";

        // SQL query to fetch all records from 'book' table
        String query = "SELECT * FROM book";

        // Load and register MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish the connection
        Connection con = DriverManager.getConnection(url, username, password);
        System.out.println("Connection established successfully");

        // Create a statement
        Statement st = con.createStatement();

        // Execute query
        ResultSet rs = st.executeQuery(query);

        // Iterate through the result set
        while (rs.next()) {
            String isbn = rs.getString("isbn");
            String bookName = rs.getString("bookName");
            String author = rs.getString("author");
            double price = rs.getDouble("price");
            String publisher = rs.getString("publisher");
            int publishingYEAR = rs.getInt("publishingYEAR");
            int qtyAvailable = rs.getInt("qtyAvailable");

            System.out.println(isbn + ", " + bookName + ", " + author + ", " + price + ", " 
                               + publisher + ", " + publishingYEAR + ", " + qtyAvailable);
        }

        // Close resources
        rs.close();
        st.close();
        con.close();
        System.out.println("Connection Closed");
    }
}
