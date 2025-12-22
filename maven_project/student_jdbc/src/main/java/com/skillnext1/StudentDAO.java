package com.skillnext1;

import java.sql.*;
import java.util.*;

public class StudentDAO {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/skillnext_db";
    private static final String USER = "root";
    private static final String PASSWORD = "PRISCILLA2006"; // consider moving to env/config

    // Add student (into student1)
    public void addStudent(Student stu) throws SQLException {
        String sql = "INSERT INTO student1 (id, name, sem, department) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, stu.getId());
            stmt.setString(2, stu.getName());
            stmt.setInt(3, stu.getSem());
            stmt.setString(4, stu.getDepartment());
            int rows = stmt.executeUpdate();
            System.out.println("Inserted rows: " + rows);
        }
    }

    // Fetch all students (from student1)
    public List<Student> getAllStudents() throws SQLException {
        String sql = "SELECT id, name, sem, department FROM student1";
        List<Student> list = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setSem(rs.getInt("sem"));
                s.setDepartment(rs.getString("department"));
                list.add(s);
            }
        }
        return list;
    }

    // Delete student (from student1)
    public boolean deleteStudent(int id) throws SQLException {
        String sql = "DELETE FROM student1 WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            System.out.println("Deleted rows: " + rows);
            return rows > 0;
        }
    }

    // Update student (in student1)
    public boolean updateStudent(Student stu) throws SQLException {
        String sql = "UPDATE student1 SET name = ?, sem = ?, department = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, stu.getName());
            stmt.setInt(2, stu.getSem());
            stmt.setString(3, stu.getDepartment());
            stmt.setInt(4, stu.getId());
            int rows = stmt.executeUpdate();
            System.out.println("Updated rows: " + rows);
            return rows > 0;
        }
    }
}
