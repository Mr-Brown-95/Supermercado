package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;

// cola-carrito
// numero de caja
// Nombre de cajero
// Operaciones de caja
// Agregar a la cola = formar el carrito
// eleminar carrito = cobrar
// saber cuantos carritos tengo formados
// hay 3 cajas
public class Caja {
    NodoCarrito cola;
    Carrito primero;
    String nombrecajero;
    int numeroCaja;
    int numeroCarritoFormado;

    public NodoCarrito getCola() {
        return cola;
    }

    public void setCola(NodoCarrito cola) {
        this.cola = cola;
    }

    public Carrito getPrimero() {
        return primero;
    }

    public String getNombrecajero() {
        return nombrecajero;
    }

    public void setNombrecajero(String nombrecajero) {
        this.nombrecajero = nombrecajero;
    }

    public int getNumeroCaja() {
        return numeroCaja;
    }

    public void setNumeroCaja(int numeroCaja) {
        this.numeroCaja = numeroCaja;
    }

    public int getNumeroCarritoFormado() {
        return numeroCarritoFormado;
    }

    public void setNumeroCarritoFormado(int numeroCarritoFormado) {
        this.numeroCarritoFormado = numeroCarritoFormado;
    }

    public NodoCarrito push(NodoCarrito p, Carrito dato) {

        if (p == null) {
            NodoCarrito nuevo = new NodoCarrito(dato);
            p = nuevo;
        } else {
            p.setSiguiente(push(p.getSiguiente(), dato));
        }
        return p;
    }

    public NodoCarrito pop(NodoCarrito p) {
        if (p != null) {
            primero = p.getDato();
            p = p.getSiguiente();
        }
        return p;
    }

    public String toString(NodoCarrito p) {
        if (p == null) return "";
        return p.getDato().toString(p.getDato().getPila()) + "\n" + toString(p.getSiguiente());
    }
    public String ticket(Carrito p) {
        if (p == null) return "";
        String nota = "Fecha: " + fechaActual() + "\n" +
                "Hora: " + horaActual() + "\n" +
                "Cajero: " + nombrecajero + "\n" +
                "Caja: " + numeroCaja + "\n" +
                "Codigo: " + p.getPila().getDato().getCodigo() + "\n" +
                "Nombre: " + p.getPila().getDato().getNombre() + "\n" +
                "precio: " + p.getPila().getDato().getPrecio() + "\n";
        return nota;
    }

    public String fechaActual() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/YYY");
        return simpleDateFormat.format(date);
    }

    public String horaActual() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        return simpleDateFormat.format(date);
    }

}