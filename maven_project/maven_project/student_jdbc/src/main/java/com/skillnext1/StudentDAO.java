package com.skillnext1;

import java.sql.*;
import java.util.*;

public class StudentDAO {

    // Correct database
    private static final String URL =
            "jdbc:mysql://localhost:3306/skillnext_db1";
    private static final String USER = "root";
    private static final String PASSWORD = "PRISCILLA2006";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // INSERT
    public void addStudent(Student s) throws SQLException {
        String sql = "INSERT INTO student1 (id, name, sem, department) VALUES (?, ?, ?, ?)";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, s.getId());
            ps.setString(2, s.getName());
            ps.setInt(3, s.getSem());
            ps.setString(4, s.getDepartment());
            ps.executeUpdate();
        }
    }

    //  UPDATE
    public boolean updateStudent(Student s) throws SQLException {
        String sql = "UPDATE student1 SET name=?, sem=?, department=? WHERE id=?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, s.getName());
            ps.setInt(2, s.getSem());
            ps.setString(3, s.getDepartment());
            ps.setInt(4, s.getId());

            return ps.executeUpdate() > 0;
        }
    }

    // DELETE
    public boolean deleteStudent(int id) throws SQLException {
        String sql = "DELETE FROM student1 WHERE id=?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    // DISPLAY
    public List<Student> getAllStudents() throws SQLException {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM student1";

        try (Connection con = getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Student s = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("sem"),
                        rs.getString("department")
                );
                list.add(s);
            }
        }
        return list;
    }
    //  BRANCH-WISE COUNT
public Map<String, Integer> getBranchWiseCount() throws SQLException {

    Map<String, Integer> map = new LinkedHashMap<>();
    String sql = "SELECT department, COUNT(*) AS count FROM student1 GROUP BY department";

    try (Connection con = getConnection();
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(sql)) {

        while (rs.next()) {
            String dept = rs.getString("department");
            int count = rs.getInt("count");
            map.put(dept, count);
        }
    }
    return map;
}
}
