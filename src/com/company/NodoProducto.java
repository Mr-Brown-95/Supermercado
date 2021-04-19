package com.company;

public class NodoProducto {

    private Producto dato;
    private NodoProducto siguiente;

    public NodoProducto(Producto dato) {
        this.dato = dato;
        this.siguiente = null;
    }


    public Producto getDato() {
        return dato;
    }

    public void setDato(Producto dato) {
        this.dato = dato;
    }

    public NodoProducto getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoProducto siguiente) {
        this.siguiente = siguiente;
    }
}
