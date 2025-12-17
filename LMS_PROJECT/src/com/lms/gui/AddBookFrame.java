package com.lms.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.lms.service.LMSDatabaseService;

public class AddBookFrame extends JFrame {

    public AddBookFrame() {
        setTitle("Add Book");
        setSize(420, 420);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel lblISBN = new JLabel("ISBN:");
        lblISBN.setBounds(30, 30, 120, 25);
        JTextField txtISBN = new JTextField();
        txtISBN.setBounds(170, 30, 180, 25);

        JLabel lblName = new JLabel("Book Name:");
        lblName.setBounds(30, 70, 120, 25);
        JTextField txtName = new JTextField();
        txtName.setBounds(170, 70, 180, 25);

        JLabel lblAuthor = new JLabel("Author:");
        lblAuthor.setBounds(30, 110, 120, 25);
        JTextField txtAuthor = new JTextField();
        txtAuthor.setBounds(170, 110, 180, 25);

        JLabel lblPrice = new JLabel("Price:");
        lblPrice.setBounds(30, 150, 120, 25);
        JTextField txtPrice = new JTextField();
        txtPrice.setBounds(170, 150, 180, 25);

        JLabel lblPublisher = new JLabel("Publisher:");
        lblPublisher.setBounds(30, 190, 120, 25);
        JTextField txtPublisher = new JTextField();
        txtPublisher.setBounds(170, 190, 180, 25);

        JLabel lblYear = new JLabel("Publishing Year:");
        lblYear.setBounds(30, 230, 120, 25);
        JTextField txtYear = new JTextField();
        txtYear.setBounds(170, 230, 180, 25);

        JLabel lblQty = new JLabel("Quantity:");
        lblQty.setBounds(30, 270, 120, 25);
        JTextField txtQty = new JTextField();
        txtQty.setBounds(170, 270, 180, 25);

        JButton btnSave = new JButton("Save");
        btnSave.setBounds(150, 320, 120, 30);

        // ✅ REAL JDBC + NAVIGATION
        btnSave.addActionListener(e -> {
            try {
                LMSDatabaseService db = new LMSDatabaseService();

                db.addBook(
                        Integer.parseInt(txtISBN.getText().trim()),
                        txtName.getText().trim(),
                        txtAuthor.getText().trim(),
                        Double.parseDouble(txtPrice.getText().trim()),
                        txtPublisher.getText().trim(),
                        Integer.parseInt(txtYear.getText().trim()),
                        Integer.parseInt(txtQty.getText().trim())
                );

                JOptionPane.showMessageDialog(this,
                        "Book added successfully");

                // ✅ Go back to Dashboard
                new DashboardFrame();
                dispose();

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this,
                        "Failed to add book");
            }
        });

        panel.add(lblISBN); panel.add(txtISBN);
        panel.add(lblName); panel.add(txtName);
        panel.add(lblAuthor); panel.add(txtAuthor);
        panel.add(lblPrice); panel.add(txtPrice);
        panel.add(lblPublisher); panel.add(txtPublisher);
        panel.add(lblYear); panel.add(txtYear);
        panel.add(lblQty); panel.add(txtQty);
        panel.add(btnSave);

        add(panel);
        setVisible(true);
    }
}
