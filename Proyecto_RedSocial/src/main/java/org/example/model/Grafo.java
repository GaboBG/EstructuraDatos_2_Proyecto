package org.example.model;

import java.util.*;

public class Grafo {

    private Map<Usuario, List<Usuario>> relaciones = new HashMap<>();

    public void agregarUsuario(Usuario u) {
        relaciones.putIfAbsent(u, new ArrayList<>());
    }

    public void agregarAmistad(Usuario u1, Usuario u2) {
        relaciones.get(u1).add(u2);
        relaciones.get(u2).add(u1);
    }

    public Map<Usuario, List<Usuario>> getRelaciones() {
        return relaciones;
    }
}