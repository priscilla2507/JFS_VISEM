package com.lms.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.lms.service.LMSDatabaseService;

public class LoginRegisterFrame extends JFrame {

    public LoginRegisterFrame() {
        setTitle("Library Management System");
        setSize(420, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel title = new JLabel("LMS Login / Register");
        title.setBounds(140, 20, 200, 25);

        JLabel lblUser = new JLabel("Username:");
        lblUser.setBounds(60, 70, 100, 25);

        JTextField txtUser = new JTextField();
        txtUser.setBounds(160, 70, 180, 25);

        JLabel lblPass = new JLabel("Password:");
        lblPass.setBounds(60, 110, 100, 25);

        JPasswordField txtPass = new JPasswordField();
        txtPass.setBounds(160, 110, 180, 25);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(80, 170, 100, 30);

        // ✅ ONLY LOGIN LOGIC (AUTHENTICATION BASED)
        btnLogin.addActionListener(e -> {
            int regID = Integer.parseInt(txtUser.getText().trim());
            String pass = new String(txtPass.getPassword());

            try {
                LMSDatabaseService db = new LMSDatabaseService();
                String role = db.authenticateUser(regID, pass);

                if (role != null) {
                    JOptionPane.showMessageDialog(this,
                        "Login successful as " + role);
                    new DashboardFrame();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this,
                        "Invalid ID or Password");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        JButton btnRegister = new JButton("Register");
        btnRegister.setBounds(220, 170, 100, 30);

        btnRegister.addActionListener(e -> {
            new RegisterFrame();
        });

        panel.add(title);
        panel.add(lblUser); panel.add(txtUser);
        panel.add(lblPass); panel.add(txtPass);
        panel.add(btnLogin); panel.add(btnRegister);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginRegisterFrame();
    }
}
