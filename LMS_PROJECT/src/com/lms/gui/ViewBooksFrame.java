package com.lms.gui;

import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ViewBooksFrame extends JFrame {

    JTable table;
    DefaultTableModel model;

    public ViewBooksFrame() {
        setTitle("View Books");
        setSize(900, 400);
        setLocationRelativeTo(null);

        String[] columns = {
            "ISBN", "Book Name", "Author",
            "Price", "Publisher", "Year", "Quantity"
        };

        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        JScrollPane sp = new JScrollPane(table);

        add(sp);
        loadBooksFromDatabase();

        setVisible(true);
    }

    private void loadBooksFromDatabase() {
        try {
            BookService service = new BookService();
            ResultSet rs = service.getAllBooks();

            model.setRowCount(0); // clear table

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("isbn"),
                    rs.getString("bookName"),
                    rs.getString("author"),
                    rs.getDouble("price"),
                    rs.getString("publisher"),
                    rs.getInt("publishingYEAR"),
                    rs.getInt("qtyAvailable")
                });
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error loading books from database");
            e.printStackTrace();
        }
    }
}
