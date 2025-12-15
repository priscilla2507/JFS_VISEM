package com.skillnext;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    private static final String URL =
            "jdbc:mysql://localhost:3306/skillnext_db";
    private static final String USER = "root";
    private static final String PASSWORD = "PRISCILLA2006"; // change if needed

    // Get DB Connection
    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
        System.out.println("Connected to DB: " + con.getCatalog());
        return con;
    }

    // INSERT employee
    public void addEmployee(Employee emp) throws Exception {
        String sql =
                "INSERT INTO employee (name, email, salary) VALUES (?, ?, ?)";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, emp.getName());
            ps.setString(2, emp.getEmail());
            ps.setDouble(3, emp.getSalary());

            ps.executeUpdate();
        }
    }

    // FETCH all employees
    public List<Employee> getAllEmployees() throws Exception {
        List<Employee> list = new ArrayList<>();

        String sql = "SELECT * FROM employee";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Employee emp = new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getDouble("salary")
                );
                list.add(emp);
            }
        }
        return list;
    }
}
