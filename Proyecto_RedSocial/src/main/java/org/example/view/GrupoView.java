package org.example.view;


import org.example.dao.DataStore;
import org.example.model.Grupo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class GrupoView extends JFrame {

    private JTextField txtNombre;
    private JComboBox<String> cbColor;
    private DefaultTableModel modelo;

    public GrupoView() {
        setTitle("Grupos");
        setSize(500,400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3,2));

        txtNombre = new JTextField();
        cbColor = new JComboBox<>(new String[]{"Rojo","Verde","Azul"});

        JButton btnGuardar = new JButton("Crear Grupo");

        btnGuardar.addActionListener(e -> guardar());

        panel.add(new JLabel("Nombre"));
        panel.add(txtNombre);
        panel.add(new JLabel("Color"));
        panel.add(cbColor);
        panel.add(new JLabel());
        panel.add(btnGuardar);

        modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");

        JTable tabla = new JTable(modelo);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(tabla), BorderLayout.CENTER);
    }

    private void guardar() {
        String nombre = txtNombre.getText();
        String colorStr = (String) cbColor.getSelectedItem();

        Color color = switch (colorStr) {
            case "Rojo" -> Color.RED;
            case "Verde" -> Color.GREEN;
            default -> Color.BLUE;
        };

        Grupo g = new Grupo(nombre, color);
        DataStore.grupos.add(g);

        modelo.addRow(new Object[]{nombre});
    }
}