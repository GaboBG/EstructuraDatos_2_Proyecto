package org.example.model;

import java.util.Objects;

public class Usuario {

    private int id;
    private String username;
    private String password; // 🔐 agregado para login
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String fecha;
    private String avatar;

    private Grupo grupo;

    // Constructor vacío
    public Usuario() {
    }

    // Constructor completo
    public Usuario(int id, String username, String password,
                   String nombre, String apellido1, String apellido2,
                   String fecha, String avatar) {

        this.id = id;
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fecha = fecha;
        this.avatar = avatar;
    }

    // ================= GETTERS & SETTERS =================

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    // ================= IMPORTANTE PARA GRAFOS =================

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario usuario = (Usuario) o;
        return id == usuario.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // ================= PARA COMBOBOX (UI) =================

    @Override
    public String toString() {
        return username;
    }
}