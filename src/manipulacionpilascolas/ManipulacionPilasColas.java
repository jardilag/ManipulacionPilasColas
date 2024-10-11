/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package manipulacionpilascolas;

import java.util.Scanner;
import pilas.*;
import colas.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @authors EDWIN RUIZ, NERLIS PEREZ, JUAN ARDILA
 */
public class ManipulacionPilasColas {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    boolean continuar = true;

    while (continuar) {
      // Mostrar el menú principal
      System.out.println("\n--- Menú Principal ---");
      System.out.println("1. Manejar Pilas de Números");
      System.out.println("2. Manejar Pilas de Palabras");
      System.out.println("3. Manejar Sistema de Mesas (Colas de Clientes)");
      System.out.println("4. Salir");
      System.out.print("Selecciona una opción: ");
      int opcion = sc.nextInt();
      sc.nextLine(); // Consumir la nueva línea

      switch (opcion) {
        case 1:
          manejarPilasNumeros(sc);
          break;
        case 2:
          manejarPilasPalabras(sc);
          break;
        case 3:
          manejarSistemaMesas(sc);
          break;
        case 4:
          continuar = false;
          System.out.println("¡Hasta luego!");
          break;
        default:
          System.out.println("Opción no válida, intenta nuevamente.");
          break;
      }
    }
    sc.close(); // Cerrar el Scanner al finalizar
  }

  // Método para manejar la pila de números
  public static void manejarPilasNumeros(Scanner sc) {
    Pila pilaA = new Pila();

    // Solicitar al usuario ingresar números para la pila
    System.out.println("¿Cuántos números deseas agregar a la PilaA?");
    int cantidadNumeros = sc.nextInt();

    for (int i = 0; i < cantidadNumeros; i++) {
      System.out.print("Ingresa un número: ");
      int numero = sc.nextInt();
      pilaA.push(numero);
    }

    System.out.println("PilaA Original:");
    pilaA.mostrar();

    // Crear PilaB con números impares en orden descendente
    Pila pilaB = new Pila();
    int[] elementosA = pilaA.obtenerElementos();
    for (int num : elementosA) {
      if (num % 2 != 0) {
        pilaB.push(num);
      }
    }

    // Ordenar PilaB en orden descendente
    int[] elementosB = pilaB.obtenerElementos();
    Integer[] numerosWrapper = Arrays.stream(elementosB).boxed().toArray(Integer[]::new);
    Arrays.sort(numerosWrapper, Collections.reverseOrder());
    elementosB = Arrays.stream(numerosWrapper).mapToInt(Integer::intValue).toArray();

    Pila PilaBOrdenada = new Pila();
    for (int i = elementosB.length - 1; i >= 0; i--) {
      PilaBOrdenada.push(elementosB[i]);
    }
    System.out.println("PilaB con impares en orden descendente:");
    PilaBOrdenada.mostrar();

    System.out.println("Proceso de manejo de pilas finalizado. Volviendo al menú principal...");
  }

  // Método para manejar la pila de palabras
  public static void manejarPilasPalabras(Scanner sc) {
    PilaPalabras pilaPalabras = new PilaPalabras();

    // Solicitar al usuario ingresar palabras para la pila
    System.out.println("¿Cuántas palabras deseas agregar a la pila de palabras?");
    int cantidadPalabras = sc.nextInt();
    sc.nextLine(); // Consumir la nueva línea

    for (int i = 0; i < cantidadPalabras; i++) {
      System.out.print("Ingresa una palabra: ");
      String palabra = sc.nextLine();
      pilaPalabras.push(palabra);
    }

    System.out.println("Pila de Palabras:");
    pilaPalabras.mostrar();

    // Buscar palabras
    System.out.print("¿Qué palabra deseas buscar? ");
    String palabraBuscar = sc.nextLine();
    pilaPalabras.buscar(palabraBuscar);

    System.out.println("Proceso de manejo de pilas de palabras finalizado. Volviendo al menú principal...");
  }

  // Método para manejar el sistema de mesas (colas de clientes)
  public static void manejarSistemaMesas(Scanner sc) {
    RestauranteColas restaurante = new RestauranteColas();
    List<TimerTask> tareasActivas = new ArrayList<>();
    Timer timer = new Timer();

    // Solicitar al usuario ingresar clientes
    System.out.println("¿Cuántos clientes deseas agregar?");
    int cantidadClientes = sc.nextInt();
    sc.nextLine();

    for (int i = 0; i < cantidadClientes; i++) {
      System.out.print("Ingresa el nombre del cliente: ");
      String nombre = sc.nextLine();
      System.out.print("¿Cuántas personas están en la mesa? ");
      int personas = sc.nextInt();
      sc.nextLine();

      Cliente cliente = new Cliente(nombre, personas);
      restaurante.asignarMesa(cliente);

      // Temporizador para liberar la mesa automáticamente en 10 segundos
      
      TimerTask liberarMesaTask = new TimerTask() {
        @Override
        public void run() {
          restaurante.liberarMesa(cliente);
          tareasActivas.remove(this);
          if (tareasActivas.isEmpty()) {
            System.out.println("Todas las mesas han sido liberadas.");
          }
        }
      };
      tareasActivas.add(liberarMesaTask);
      timer.schedule(liberarMesaTask, 10000); // 10 segundos
    }

    while (!tareasActivas.isEmpty()) {
      try {
        Thread.sleep(1000); // Esperar 1 segundo antes de verificar nuevamente
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        System.out.println("El proceso fue interrumpido.");
      }
    }

    for (TimerTask task : tareasActivas) {
      task.cancel();
    }
    timer.cancel();

    System.out.println("Proceso de manejo del sistema de mesas finalizado. Volviendo al menú principal...");
  }

}
