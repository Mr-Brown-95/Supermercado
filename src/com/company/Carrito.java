package com.company;

/*  pila
    operaciones de pila
    operacion contar
 */

public class Carrito {

    NodoProducto pila;
    Producto ultimo;

    public NodoProducto getPila() {
        return pila;
    }

    public void setPila(NodoProducto pila) {
        this.pila = pila;
    }

    public Producto getUltimo() {
        return ultimo;
    }

    public void setUltimo(Producto ultimo) {
        this.ultimo = ultimo;
    }

    public NodoProducto push(NodoProducto p, Producto dato) { //Este metodo permite agregar dato a la pila

        if (p == null) {
            NodoProducto nuevo = new NodoProducto(dato);
            p = nuevo;
        } else {
            p.setSiguiente(push(p.getSiguiente(), dato));
        }
        return p;
    }

    public NodoProducto pop(NodoProducto p) { //Este metodo permite eliminar dato a la pila
        if (p.getSiguiente() == null) {
            ultimo = p.getDato();
            p = null;
        } else {
            p.setSiguiente(pop(p.getSiguiente()));

        }
        return p;
    }

    public String toString(NodoProducto p) {
        if (p == null) return "";
        return p.getDato().getCodigo() + "  " + p.getDato().getNombre() + "  " + p.getDato().getPrecio() + "  " + "\n" + toString(p.getSiguiente());
    }
}
