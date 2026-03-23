package org.example.view;

import org.example.dao.DataStore;
import org.example.model.Usuario;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {

    private JTextField txtUser;
    private JPasswordField txtPass;

    public LoginView() {
        setTitle("Login");
        setSize(350,220);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4,2,10,10));

        txtUser = new JTextField();
        txtPass = new JPasswordField();

        JButton btnLogin = new JButton("Login");
        JButton btnRegister = new JButton("Registrarse");

        btnLogin.addActionListener(e -> login());
        btnRegister.addActionListener(e -> abrirRegistro());

        panel.add(new JLabel("Usuario:"));
        panel.add(txtUser);

        panel.add(new JLabel("Password:"));
        panel.add(txtPass);

        panel.add(btnLogin);
        panel.add(btnRegister);

        add(panel);
    }

    // 🔐 LOGIN
    private void login() {

        String username = txtUser.getText().trim();
        String password = new String(txtPass.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese usuario y contraseña");
            return;
        }

        for (Usuario u : DataStore.usuarios) {

            if (u.getUsername().equals(username) &&
                    u.getPassword().equals(password)) {

                JOptionPane.showMessageDialog(this, "Bienvenido " + u.getUsername());

                new MainMenu().setVisible(true);
                dispose();
                return;
            }
        }

        JOptionPane.showMessageDialog(this,
                "Usuario o contraseña incorrectos");
    }

    // 🔄 ABRIR REGISTRO
    private void abrirRegistro() {
        new UsuarioView(this).setVisible(true);
        this.setVisible(false);
    }

    // 🚀 MAIN opcional (para probar directo)
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LoginView().setVisible(true);
        });
    }
}