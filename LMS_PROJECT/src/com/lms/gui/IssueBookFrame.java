package com.lms.gui;

import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.lms.service.LMSDatabaseService;

public class IssueBookFrame extends JFrame {

    public IssueBookFrame() {

        setTitle("Issue Book");
        setSize(450, 480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel lblIssueId = new JLabel("Issue ID:");
        lblIssueId.setBounds(30, 30, 150, 25);
        JTextField txtIssueId = new JTextField();
        txtIssueId.setBounds(200, 30, 180, 25);

        JLabel lblISBN = new JLabel("ISBN:");
        lblISBN.setBounds(30, 70, 150, 25);
        JTextField txtISBN = new JTextField();
        txtISBN.setBounds(200, 70, 180, 25);

        JLabel lblBookName = new JLabel("Book Name:");
        lblBookName.setBounds(30, 110, 150, 25);
        JTextField txtBookName = new JTextField();
        txtBookName.setBounds(200, 110, 180, 25);

        JLabel lblRegId = new JLabel("Reg ID:");
        lblRegId.setBounds(30, 150, 150, 25);
        JTextField txtRegId = new JTextField();
        txtRegId.setBounds(200, 150, 180, 25);

        JLabel lblName = new JLabel("Student Name:");
        lblName.setBounds(30, 190, 150, 25);
        JTextField txtName = new JTextField();
        txtName.setBounds(200, 190, 180, 25);

        JLabel lblReserve = new JLabel("Reserve Date (YYYY-MM-DD):");
        lblReserve.setBounds(30, 230, 200, 25);
        JTextField txtReserve = new JTextField();
        txtReserve.setBounds(200, 230, 180, 25);

        JLabel lblIssue = new JLabel("Issue Date (YYYY-MM-DD):");
        lblIssue.setBounds(30, 270, 200, 25);
        JTextField txtIssue = new JTextField();
        txtIssue.setBounds(200, 270, 180, 25);

        JLabel lblRenew = new JLabel("Renewal Date (YYYY-MM-DD):");
        lblRenew.setBounds(30, 310, 200, 25);
        JTextField txtRenew = new JTextField();
        txtRenew.setBounds(200, 310, 180, 25);

        JLabel lblReturn = new JLabel("Returned Date (YYYY-MM-DD):");
        lblReturn.setBounds(30, 350, 200, 25);
        JTextField txtReturn = new JTextField();
        txtReturn.setBounds(200, 350, 180, 25);

        JLabel lblStatus = new JLabel("Status:");
        lblStatus.setBounds(30, 390, 150, 25);
        JComboBox<String> statusBox =
                new JComboBox<>(new String[]{"Issued", "Returned"});
        statusBox.setBounds(200, 390, 180, 25);

        JButton btnIssue = new JButton("Issue Book");
        btnIssue.setBounds(150, 430, 140, 30);

      
        btnIssue.addActionListener(e -> {
            try {
                LMSDatabaseService db = new LMSDatabaseService();

                db.issueBook(
                        Integer.parseInt(txtIssueId.getText().trim()),
                        Integer.parseInt(txtISBN.getText().trim()),
                        txtBookName.getText().trim(),
                        Integer.parseInt(txtRegId.getText().trim()),
                        txtName.getText().trim(),
                        Date.valueOf(txtReserve.getText().trim()),
                        Date.valueOf(txtIssue.getText().trim()),
                        Date.valueOf(txtRenew.getText().trim()),
                        Date.valueOf(txtReturn.getText().trim()),
                        statusBox.getSelectedItem().toString()
                );

                JOptionPane.showMessageDialog(this,
                        "Book issued successfully");

                new DashboardFrame();
                dispose();

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this,
                        "Failed to issue book");
            }
        });

        panel.add(lblIssueId); panel.add(txtIssueId);
        panel.add(lblISBN); panel.add(txtISBN);
        panel.add(lblBookName); panel.add(txtBookName);
        panel.add(lblRegId); panel.add(txtRegId);
        panel.add(lblName); panel.add(txtName);
        panel.add(lblReserve); panel.add(txtReserve);
        panel.add(lblIssue); panel.add(txtIssue);
        panel.add(lblRenew); panel.add(txtRenew);
        panel.add(lblReturn); panel.add(txtReturn);
        panel.add(lblStatus); panel.add(statusBox);
        panel.add(btnIssue);

        add(panel);
        setVisible(true);
    }
}
