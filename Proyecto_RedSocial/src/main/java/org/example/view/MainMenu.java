package org.example.view;


import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {

    public MainMenu() {
        setTitle("Menú Principal");
        setSize(400,350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4,1,15,15));
        panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        JButton btnUsuarios = new JButton("Gestión de Usuarios");
        JButton btnGrupos = new JButton("Gestión de Grupos");
        JButton btnGrafo = new JButton("Ver Red Social (Grafo)");
        JButton btnSalir = new JButton("Cerrar Sesión");

        // 🔹 Acciones
        btnUsuarios.addActionListener(e -> {
            new UsuarioView(null).setVisible(true); // null porque no viene de login
        });

        btnGrupos.addActionListener(e -> {
            new GrupoView().setVisible(true);
        });

        btnGrafo.addActionListener(e -> {
            new MainUI().setVisible(true);
        });

        btnSalir.addActionListener(e -> {
            new LoginView().setVisible(true);
            dispose();
        });

        // 🔹 Agregar botones
        panel.add(btnUsuarios);
        panel.add(btnGrupos);
        panel.add(btnGrafo);
        panel.add(btnSalir);

        add(panel);
    }
}