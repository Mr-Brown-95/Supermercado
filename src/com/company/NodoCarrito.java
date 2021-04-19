package com.company;

public class NodoCarrito {

    private Carrito dato;
    private NodoCarrito siguiente;

    public NodoCarrito(Carrito dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public Carrito getDato() {
        return dato;
    }

    public void setDato(Carrito dato) {
        this.dato = dato;
    }

    public NodoCarrito getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCarrito siguiente) {
        this.siguiente = siguiente;
    }
}
