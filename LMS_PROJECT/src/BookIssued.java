import java.sql.*;

public class BookIssued {
    public static void main(String[] args) throws Exception {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/lms";
        String username = "root";
        String password = "";

        // SQL query to fetch all records from 'bookissued' table
        String query = "SELECT * FROM bookissued";

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
            int issueID = rs.getInt("issueID");
            String isbn = rs.getString("isbn");
            String bookName = rs.getString("bookName");
            int regID = rs.getInt("regID");
            String name = rs.getString("name");
            Date reserveDate = rs.getDate("reserveDate");
            Date issueDate = rs.getDate("issueDate");
            Date renewalDate = rs.getDate("renewalDate");
            Date returnedDate = rs.getDate("returnedDate");
            String status = rs.getString("status");

            System.out.println(issueID + ", " + isbn + ", " + bookName + ", " + regID + ", " 
                    + name + ", " + reserveDate + ", " + issueDate + ", " 
                    + renewalDate + ", " + returnedDate + ", " + status);
        }

        // Close resources
        rs.close();
        st.close();
        con.close();
        System.out.println("Connection Closed");
    }
}
