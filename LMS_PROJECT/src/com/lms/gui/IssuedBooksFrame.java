package com.lms.gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class IssuedBooksFrame extends JFrame {

    public IssuedBooksFrame() {
        setTitle("Issued Books");
        setSize(1000, 400);
        setLocationRelativeTo(null);

        String[] columns = {
            "Issue ID", "ISBN", "Book Name", "Reg ID", "Student Name",
            "Reserve Date", "Issue Date", "Renewal Date", "Returned Date", "Status"
        };

        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);

        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/lms",
                    "root",
                    ""
            );

            String sql = "SELECT * FROM bookissued";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("issueID"),
                        rs.getInt("isbn"),
                        rs.getString("bookName"),
                        rs.getInt("regID"),
                        rs.getString("name"),
                        rs.getDate("reserveDate"),
                        rs.getDate("issueDate"),
                        rs.getDate("renewalDate"),
                        rs.getDate("returnedDate"),
                        rs.getString("status")
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        add(new JScrollPane(table));
        setVisible(true);
    }
}
