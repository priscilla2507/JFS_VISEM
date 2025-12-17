import java.sql.*;

public class Register {
    public static void main(String[] args) throws Exception {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/lms";
        String username = "root";
        String password = "";

        // SQL query to fetch all records from 'register' table
        String query = "SELECT * FROM register";

        // Load and register MySQL JDBC driver (newer versions use com.mysql.cj.jdbc.Driver)
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
            int regID = rs.getInt("regID");
            String name = rs.getString("name");
            String email = rs.getString("email");
            String pass = rs.getString("pass");
            long mobile = rs.getLong("mobile");
            
            String address = rs.getString("address");
            String roleName = rs.getString("roleName");

            System.out.println(regID + ", " + name + ", " + email + ", " + pass + ", " 
                               + mobile + ", " + address + ", " + roleName);
        }

        // Close resources
        rs.close();
        st.close();
        con.close();
        System.out.println("Connection Closed");
    }
}
