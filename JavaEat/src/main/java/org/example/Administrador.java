package org.example;
import java.util.ArrayList;
import java.util.List;
public class Administrador {
    // Método para obtener todos los clientes

    public static List<Cliente> clientes = new ArrayList<>();     
    public static void agregarCliente(Cliente cliente) {
                // agregar algunos clientes a la lista (aquí se podrían cargar los datos desde una base de dat
        clientes.add(cliente);

    }
    public static List<Cliente> obtenerTodosLosClientes() {
        // crear una lista vacía para almacenar los clientes
        
         clientes.add(new Particular("Juan", "03225648H", "juan@gmail.com", "1234-5678-9012-3456", new Direccion("Av. Siempreviva", 742, 43005, "Tarragona"),new TarjetaCredito(1234,"12/24",34)));
        //clientes.add(new Empresa("Acme Inc.", "ventas@acme.com", "654321", new Direccion("Av. Siempreviva", 742, 28001, "Madrid"), "5423-1331-2136-125", "3248572H", "www.acme.es"));

        return clientes;
    }

}
