/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pilas;

/**
 *
 * @author SSSA
 */
public class Pila {
    private Nodo cima;

    public Pila() {
        this.cima = null;
    }

    public void push(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        nuevoNodo.siguiente = cima;
        cima = nuevoNodo;
    }

    public int pop() {
        if (cima == null) {
            throw new RuntimeException("La pila está vacía");
        }
        int dato = cima.dato;
        cima = cima.siguiente;
        return dato;
    }

    public boolean estaVacia() {
        return cima == null;
    }

    public void mostrar() {
        Nodo actual = cima;
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }

    public int[] obtenerElementos() {
        int tamanio = contarElementos();
        int[] elementos = new int[tamanio];
        Nodo actual = cima;
        int index = 0;
        while (actual != null) {
            elementos[index++] = actual.dato;
            actual = actual.siguiente;
        }
        return elementos;
    }

    public int contarElementos() {
        int contador = 0;
        Nodo actual = cima;
        while (actual != null) {
            contador++;
            actual = actual.siguiente;
        }
        return contador;
    }
}