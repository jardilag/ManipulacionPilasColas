/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colas;

/**
 *
 * @author SSSA
 */
public class RestauranteColas {
    private ColaClientes colaEspera = new ColaClientes();
    private int mesasDisponible2 = 10;
    private int mesasDisponible4 = 8;
    private int mesasDisponible6 = 7;

    public void asignarMesa(Cliente cliente) {
        if (cliente.getPersonas() <= 2 && mesasDisponible2 > 0) {
            mesasDisponible2--;
            System.out.println("Cliente " + cliente.getNombre() + " asignado a mesa para 2 personas.");
        } else if (cliente.getPersonas() > 2 && cliente.getPersonas() <= 4 && mesasDisponible4 > 0) {
            mesasDisponible4--;
            System.out.println("Cliente " + cliente.getNombre() + " asignado a mesa para 4 personas.");
        } else if (cliente.getPersonas() > 4 && cliente.getPersonas() <= 6 && mesasDisponible6 > 0) {
            mesasDisponible6--;
            System.out.println("Cliente " + cliente.getNombre() + " asignado a mesa para 6 personas.");
        } else {
            System.out.println("No hay mesas disponibles para " + cliente.getPersonas() + " personas. " +  cliente.getNombre() + " añadido a la cola de espera.");
            colaEspera.encolar(cliente);
        }
    }

    public void liberarMesa(Cliente cliente) {
        int capacidad = cliente.getPersonas();
        switch (capacidad) {
            case 2: 
                mesasDisponible2++; 
                break;
            case 4:
                mesasDisponible4++;
                break;
            case 6: 
                mesasDisponible6++; 
                break;
        }
        System.out.println("Mesa para " + capacidad + " personas liberada.");

        if (!colaEspera.estaVacia()) {
            Cliente siguiente = colaEspera.desencolar();
            asignarMesa(siguiente);
            System.out.println("Cliente " + siguiente.getNombre() + " asignado a mesa para " + siguiente.getPersonas() + " personas desde la cola de espera.");
        }
    }
}