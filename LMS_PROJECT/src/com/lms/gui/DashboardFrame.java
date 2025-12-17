package com.lms.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DashboardFrame extends JFrame {

    public DashboardFrame() {
        setTitle("LMS Dashboard");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel title = new JLabel("Dashboard");
        title.setBounds(160, 20, 100, 25);

        JButton btnAddBook = new JButton("Add Book");
        btnAddBook.setBounds(120, 70, 160, 30);

        JButton btnViewBook = new JButton("View Books");
        btnViewBook.setBounds(120, 110, 160, 30);

        JButton btnIssueBook = new JButton("Issue Book");
        btnIssueBook.setBounds(120, 150, 160, 30);

        JButton btnIssuedList = new JButton("Issued Books");
        btnIssuedList.setBounds(120, 190, 160, 30);

        JButton btnLogout = new JButton("Logout");
        btnLogout.setBounds(120, 240, 160, 30);

        btnAddBook.addActionListener(e -> new AddBookFrame());
        btnViewBook.addActionListener(e -> new ViewBooksFrame());
        btnIssueBook.addActionListener(e -> new IssueBookFrame());
        btnIssuedList.addActionListener(e -> new IssuedBooksFrame());
        btnLogout.addActionListener(e -> {
            new LoginRegisterFrame();
            dispose();
        });

        panel.add(title);
        panel.add(btnAddBook);
        panel.add(btnViewBook);
        panel.add(btnIssueBook);
        panel.add(btnIssuedList);
        panel.add(btnLogout);

        add(panel);
        setVisible(true);
    }
}
