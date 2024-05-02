package org.example;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import static org.example.Informacion.listaComidas;
import static org.example.Informacion.listaParticulares;
import static org.example.Informacion.listaRestaurantes;

public class Main {

    public static void main(String[] args) {
        try{

        

        //System.out.println("precio total:" + CateringMenu.precio(menu) + "€");
        Particular particular1 = (new Particular("Juan", "03225648H", "juan@gmail.com", "1234-5678-9012-3456", new Direccion("Av. Siempreviva", 742, 43005, "Tarragona"), new TarjetaCredito(1234, "12/24", 34)));
        listaParticulares.add(particular1);
        
        Comida comida1 = new Comida("kebab", "Pollo, ternera y Salsa", 5.0);
        Comida comida2 = new Comida("pizza", "Masa, tomate, queso y Jamon", 9.5);
        Comida comida3 = new Comida("torreznos", "Torreznos", 4.5);
        Comida comida4 = new Comida("Pizza", "Tomate,masa,queso", 10.5);
        Comida comida5 = new Comida("Hamburguesa", "Tomate, queso,bacon", 12.0);
        listaComidas.add(comida1);
        listaComidas.add(comida2);
        listaComidas.add(comida3);
        listaComidas.add(comida4);
        listaComidas.add(comida5);
        for (Comida comida : listaComidas) {
            System.out.println(comida.toString());
        }

        Restaurante restaurante1 = new Restaurante("039061882F", "Kebab Parsa", new Direccion("Calle del Moro", 2, 19200, "Azuqueca de Henares"), "Turca", 0, 0.99, 30, new Catering(false), listaComidas,20.0,5);
        Restaurante restaurante2 = new Restaurante("035123853H", "Domino's pizza", new Direccion("Calle Roma", 7, 28801, "Alcalá de Henares"), "Italiana", 0, 4.99, 30, new Catering(true), listaComidas,15.0,5);
        Restaurante restaurante3 = new Restaurante("029461719U", "Buda Kaioken", new Direccion("Calle dorayaki", 11, 19201, "Guadalajara"), "Asiática", 0, 2.99, 30, new Catering(false), listaComidas,10.0,5);
        listaRestaurantes.add(restaurante1);
        listaRestaurantes.add(restaurante2);
        listaRestaurantes.add(restaurante3);
        
        Informacion.cargarDatos();
        System.out.print(".\n\n.");

        // Crear una instancia de la clase Administrador
        Administrador administrador = new Administrador();

        // Llamar al método obtenerTodosLosClientes() para obtener todos los clientes
        //List<Cliente> clientes = administrador.obtenerTodosLosClientes();

        VentanaPrincipalParticular ventana = new VentanaPrincipalParticular();

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.pack();

        VentanaInicioSesion miVentana = new VentanaInicioSesion();
        miVentana.setVisible(true);
        // Imprimir los datos de cada cliente
        
    } finally{
    Informacion.guardarDatos();
    Informacion.cargarDatos();}
    }
}
