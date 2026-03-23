package org.example.dao;

import org.example.model.Usuario;
import org.example.model.Grupo;

import java.util.ArrayList;
import java.util.List;

public class DataStore {

    public static List<Usuario> usuarios = new ArrayList<>();
    public static List<Grupo> grupos = new ArrayList<>();

    public static int idUsuario = 1;
}