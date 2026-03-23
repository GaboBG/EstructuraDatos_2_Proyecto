package org.example.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Grupo {

    private String nombre;
    private Color color;
    private List<Usuario> usuarios;

    public Grupo(String nombre, Color color) {
        this.nombre = nombre;
        this.color = color;
        this.usuarios = new ArrayList<>();
    }

    public void agregarUsuario(Usuario u) {
        usuarios.add(u);
    }

    public String getNombre() {
        return nombre;
    }

    public Color getColor() {
        return color;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
    @Override
    public String toString() {
        return nombre + " (" + usuarios.size() + " usuarios)";
    }
}