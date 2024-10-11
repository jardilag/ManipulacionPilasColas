/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colas;

/**
 *
 * @author SSSA
 */
public class Cliente {

  private String nombre;
  private int personas;

  public Cliente(String nombre, int personas) {
    this.nombre = nombre;
    this.personas = personas;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getPersonas() {
    return personas;
  }

  public void setPersonas(int personas) {
    this.personas = personas;
  }

}
