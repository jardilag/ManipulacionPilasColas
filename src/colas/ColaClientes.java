/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colas;

/**
 *
 * @author SSSA
 */
public class ColaClientes {
    private NodoCliente frente;
    private NodoCliente finalCola;

    public ColaClientes() {
        this.frente = null;
        this.finalCola = null;
    }

    public void encolar(Cliente cliente) {
        NodoCliente nuevoNodo = new NodoCliente(cliente);
        if (finalCola != null) {
            finalCola.siguiente = nuevoNodo;
        }
        finalCola = nuevoNodo;
        if (frente == null) {
            frente = nuevoNodo;
        }
    }

    public Cliente desencolar() {
        if (frente == null) {
            return null;
        }
        Cliente cliente = frente.cliente;
        frente = frente.siguiente;
        if (frente == null) {
            finalCola = null;
        }
        return cliente;
    }

    public boolean estaVacia() {
        return frente == null;
    }
}
