package org.example.view;

import org.example.dao.DataStore;
import org.example.model.Grafo;
import org.example.model.Usuario;

import javax.swing.*;
import java.awt.*;

public class MainUI extends JFrame {

    private Grafo grafo;
    private GrafoPanel panel;

    public MainUI() {
        setTitle("Grafo Red Social");
        setSize(800,600);
        setLocationRelativeTo(null);

        grafo = new Grafo();
        panel = new GrafoPanel(grafo);

        JButton btnCargar = new JButton("Cargar Usuarios");
        JButton btnRelacion = new JButton("Crear Relaciones");

        btnCargar.addActionListener(e -> cargarUsuarios());
        btnRelacion.addActionListener(e -> relaciones());

        JPanel top = new JPanel();
        top.add(btnCargar);
        top.add(btnRelacion);

        add(top, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
    }

    private void cargarUsuarios() {
        grafo.getRelaciones().clear();

        for (Usuario u : DataStore.usuarios) {
            grafo.agregarUsuario(u);
        }

        panel.repaint();
    }

    private void relaciones() {
        for(int i=0; i<DataStore.usuarios.size()-1; i++) {
            grafo.agregarAmistad(
                    DataStore.usuarios.get(i),
                    DataStore.usuarios.get(i+1)
            );
        }

        panel.repaint();
    }
}