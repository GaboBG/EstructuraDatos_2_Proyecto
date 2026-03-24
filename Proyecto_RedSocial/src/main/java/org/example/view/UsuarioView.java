package org.example.view;

import org.example.dao.DataStore;
import org.example.model.Usuario;
import org.example.model.Grupo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class UsuarioView extends JFrame {

    private JTextField txtUsername, txtNombre, txtPassword;
    private JComboBox<Grupo> cbGrupo;
    private DefaultTableModel modelo;

    private LoginView loginView;

    public UsuarioView(LoginView loginView) {
        this.loginView = loginView;

        setTitle("Registro Usuario");
        setSize(600,400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5,2));

        txtUsername = new JTextField();
        txtNombre = new JTextField();
        txtPassword = new JTextField();

        cbGrupo = new JComboBox<>();
        cargarGrupos();

        JButton btnGuardar = new JButton("Registrarse");

        btnGuardar.addActionListener(e -> guardar());

        panel.add(new JLabel("Username"));
        panel.add(txtUsername);

        panel.add(new JLabel("Password"));
        panel.add(txtPassword);

        panel.add(new JLabel("Nombre"));
        panel.add(txtNombre);

        panel.add(new JLabel("Grupo"));
        panel.add(cbGrupo);

        panel.add(new JLabel());
        panel.add(btnGuardar);

        modelo = new DefaultTableModel();

        add(panel, BorderLayout.NORTH);
    }

    private void cargarGrupos() {
        for(Grupo g : DataStore.grupos) {
            cbGrupo.addItem(g);
        }
    }

    private void guardar() {

        if(txtUsername.getText().isEmpty() || txtPassword.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Datos incompletos");
            return;
        }

        Usuario u = new Usuario();
        u.setId(DataStore.idUsuario++);
        u.setUsername(txtUsername.getText());
        u.setPassword(txtPassword.getText());
        u.setNombre(txtNombre.getText());

        Grupo g = (Grupo) cbGrupo.getSelectedItem();
        u.setGrupo(g);

        if(g != null) g.agregarUsuario(u);

        DataStore.usuarios.add(u);

        JOptionPane.showMessageDialog(this, "Usuario registrado correctamente");


        if (loginView != null) {
            loginView.setVisible(true);
        }

        dispose(); // cerrar registro
    }
}