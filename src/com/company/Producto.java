package com.company;

public class Producto {
    private int codigo;
    private String Nombre;
    private float Precio;
    private int Existencias;

    public Producto(int codigo, String nombre, float precio, int existencias) {
        this.codigo = codigo;
        Nombre = nombre;
        Precio = precio;
        Existencias = existencias;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public float getPrecio() {
        return Precio;
    }

    public void setPrecio(float precio) {
        Precio = precio;
    }

    public int getExistencias() {
        return Existencias;
    }

    public void setExistencias(int existencias) {
        Existencias = existencias;
    }
}