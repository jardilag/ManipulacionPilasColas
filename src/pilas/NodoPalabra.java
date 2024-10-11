/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pilas;

/**
 *
 * @author SSSA
 */
public class NodoPalabra {
    public String dato;
    public NodoPalabra siguiente;

    public NodoPalabra(String dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}