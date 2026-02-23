package com.skillnext1;

import java.sql.*;
import java.util.*;

public class App {
    public static void main(String[] args) {
        // change URL/USER/PASSWORD in StudentDAO if needed
        try (Scanner sc = new Scanner(System.in)) {
            // load driver (optional with modern JDBC but harmless)
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                System.out.println("MySQL JDBC driver not found on classpath.");
            }

            StudentDAO dao = new StudentDAO();

            while (true) {
                System.out.println("\n1.Insert  2.Update  3.Delete  4.Display  5.Exit");
                System.out.print("Choose: ");
                int ch = sc.nextInt();

                if (ch == 1) {
                    System.out.println("Enter id, name, sem, dept:");
                    int id = sc.nextInt();
                    String name = sc.next();
                    int sem = sc.nextInt();
                    String dept = sc.next();

                    Student s = new Student(id, name, sem, dept);
                    try {
                        dao.addStudent(s);
                        System.out.println("Inserted.");
                    } catch (SQLException e) {
                        System.err.println("Insert failed: " + e.getMessage());
                    }

                } else if (ch == 2) {
                    System.out.println("Enter id, name, sem, dept to update:");
                    int id = sc.nextInt();
                    String name = sc.next();
                    int sem = sc.nextInt();
                    String dept = sc.next();

                    Student s = new Student(id, name, sem, dept);
                    try {
                        boolean ok = dao.updateStudent(s);
                        if (ok) System.out.println("Updated.");
                        else System.out.println("No row found with id=" + id);
                    } catch (SQLException e) {
                        System.err.println("Update failed: " + e.getMessage());
                    }

                } else if (ch == 3) {
                    System.out.println("Enter id to delete:");
                    int id = sc.nextInt();
                    try {
                        boolean ok = dao.deleteStudent(id);
                        if (ok) System.out.println("Deleted.");
                        else System.out.println("No row found with id=" + id);
                    } catch (SQLException e) {
                        System.err.println("Delete failed: " + e.getMessage());
                    }

                } else if (ch == 4) {
                    try {
                        List<Student> list = dao.getAllStudents();
                        if (list.isEmpty()) {
                            System.out.println("No students found.");
                        } else {
                            for (Student s : list) System.out.println(s);
                        }
                    } catch (SQLException e) {
                        System.err.println("Fetch failed: " + e.getMessage());
                    }

                } else {
                    System.out.println("Exiting...");
                    break;
                }
            }
        }
    }
}
