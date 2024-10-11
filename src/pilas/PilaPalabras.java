/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pilas;

/**
 *
 * @author SSSA
 */
public class PilaPalabras {
    private NodoPalabra cima;

    public PilaPalabras() {
        this.cima = null;
    }

    public void push(String palabra) {
        NodoPalabra nuevoNodo = new NodoPalabra(palabra);
        nuevoNodo.siguiente = cima;
        cima = nuevoNodo;
    }

    public boolean buscar(String palabra) {
        NodoPalabra actual = cima;
        int posicion = 1;
        while (actual != null) {
            if (actual.dato.equals(palabra)) {
                System.out.println("La palabra '" + palabra + "' está en la posición " + posicion);
                return true;
            }
            actual = actual.siguiente;
            posicion++;
        }
        System.out.println("La palabra '" + palabra + "' no está en la pila.");
        return false;
    }

    public void mostrar() {
        NodoPalabra actual = cima;
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }
}
