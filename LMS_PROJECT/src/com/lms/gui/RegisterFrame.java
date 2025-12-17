package com.lms.gui;

import javax.swing.*;

import com.lms.service.LMSDatabaseService;

public class RegisterFrame extends JFrame {

    public RegisterFrame() {
        setTitle("User Registration");
        setSize(450, 420);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel title = new JLabel("Register New User");
        title.setBounds(160, 20, 200, 25);

        JLabel lblId = new JLabel("Reg ID:");
        lblId.setBounds(50, 70, 120, 25);
        JTextField txtId = new JTextField();
        txtId.setBounds(180, 70, 180, 25);

        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(50, 110, 120, 25);
        JTextField txtName = new JTextField();
        txtName.setBounds(180, 110, 180, 25);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(50, 150, 120, 25);
        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(180, 150, 180, 25);

        JLabel lblPass = new JLabel("Password:");
        lblPass.setBounds(50, 190, 120, 25);
        JPasswordField txtPass = new JPasswordField();
        txtPass.setBounds(180, 190, 180, 25);

        JLabel lblMobile = new JLabel("Mobile:");
        lblMobile.setBounds(50, 230, 120, 25);
        JTextField txtMobile = new JTextField();
        txtMobile.setBounds(180, 230, 180, 25);

        JLabel lblAddress = new JLabel("Address:");
        lblAddress.setBounds(50, 270, 120, 25);
        JTextField txtAddress = new JTextField();
        txtAddress.setBounds(180, 270, 180, 25);

        JLabel lblRole = new JLabel("Role:");
        lblRole.setBounds(50, 310, 120, 25);
        JComboBox<String> roleBox =
                new JComboBox<>(new String[]{"Student", "Librarian"});
        roleBox.setBounds(180, 310, 180, 25);

        JButton btnRegister = new JButton("Register");
        btnRegister.setBounds(170, 350, 120, 30);

        // ✅ JDBC REGISTER
        btnRegister.addActionListener(e -> {
            try {
                LMSDatabaseService db = new LMSDatabaseService();
                db.registerUser(
                        Integer.parseInt(txtId.getText().trim()),
                        txtName.getText().trim(),
                        txtEmail.getText().trim(),
                        new String(txtPass.getPassword()),
                        txtMobile.getText().trim(),
                        txtAddress.getText().trim(),
                        roleBox.getSelectedItem().toString()
                );
                JOptionPane.showMessageDialog(this,
                        "Registration Successful");
                dispose(); // close register page
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this,
                        "Registration Failed");
            }
        });

        panel.add(title);
        panel.add(lblId); panel.add(txtId);
        panel.add(lblName); panel.add(txtName);
        panel.add(lblEmail); panel.add(txtEmail);
        panel.add(lblPass); panel.add(txtPass);
        panel.add(lblMobile); panel.add(txtMobile);
        panel.add(lblAddress); panel.add(txtAddress);
        panel.add(lblRole); panel.add(roleBox);
        panel.add(btnRegister);

        add(panel);
        setVisible(true);
    }
}