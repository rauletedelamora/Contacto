package com.raulmora.contactos;

/**
 * Created by Raul Mora on 30/08/2016.
 */
public class Contacto {

    private String nombre;
    private String telefono;
    private String email;
    private String descripcion;
    private int dia;
    private int mes;
    private int año;

    public Contacto(String nombre, String telefono, String email, String descripcion, int dia, int mes, int año) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.descripcion = descripcion;
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
