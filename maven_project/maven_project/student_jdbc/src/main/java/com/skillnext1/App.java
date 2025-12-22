package com.skillnext1;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Driver not found");
        }

        StudentDAO dao = new StudentDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println(
                "\n1.Insert  2.Update  3.Delete  4.Display  5.Exit  6.Branch Wise Count"
            );
            System.out.print("Choose: ");
            int ch = sc.nextInt();

            try {
                switch (ch) {

                    case 1:
                        System.out.println("Enter id, name, sem, department:");
                        int id = sc.nextInt();
                        String name = sc.next();
                        int sem = sc.nextInt();
                        String dept = sc.next();

                        dao.addStudent(new Student(id, name, sem, dept));
                        System.out.println("Inserted.");
                        break;

                    case 2:
                        System.out.println("Enter id, name, sem, department to update:");
                        id = sc.nextInt();
                        name = sc.next();
                        sem = sc.nextInt();
                        dept = sc.next();

                        if (dao.updateStudent(new Student(id, name, sem, dept)))
                            System.out.println("Updated.");
                        else
                            System.out.println("ID not found.");
                        break;

                    case 3:
                        System.out.println("Enter id to delete:");
                        id = sc.nextInt();

                        if (dao.deleteStudent(id))
                            System.out.println("Deleted.");
                        else
                            System.out.println("ID not found.");
                        break;

                    case 4:
                        List<Student> list = dao.getAllStudents();
                        if (list.isEmpty())
                            System.out.println("No records found.");
                        else
                            list.forEach(System.out::println);
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        sc.close();
                        return;

                    
                    case 6:
                        Map<String, Integer> map = dao.getBranchWiseCount();
                        if (map.isEmpty()) {
                            System.out.println("No records found.");
                        } else {
                            System.out.println("\nBranch Wise Student Count:");
                            for (Map.Entry<String, Integer> e : map.entrySet()) {
                                System.out.println(e.getKey() + " : " + e.getValue());
                            }
                        }
                        break;

                    default:
                        System.out.println("Invalid choice");
                }
            } catch (SQLException e) {
                System.err.println("Database error: " + e.getMessage());
            }
        }
    }
}
