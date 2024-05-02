/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alejandro Torres
 */
import java.util.ArrayList;
import java.util.List;

public class Informacion {

    public static List<Restaurante> listaRestaurantes = new ArrayList<>();
    public static List<Particular> listaParticulares = new ArrayList<>();
    public static List<Empresa> listaEmpresas = new ArrayList<>();
    public static ArrayList<Comida> listaComidas = new ArrayList<>();
    

    public static void main(String[] args) {
        // TODO code application logic here
        /*Particular particular1 = (new Particular("Juan", "03225648H", "juan@gmail.com", "1234-5678-9012-3456", new Direccion("Av. Siempreviva", 742, 43005, "Tarragona"), new TarjetaCredito(1234, "12/24", 34)));
        listaParticulares.add(particular1);

        Comida comida1 = new Comida("Pizza", "Tomate,masa,queso", 10.5);
        Comida comida2 = new Comida("Hamburguesa", "Tomate, queso,bacon", 12.0);

        listaComidas.add(comida1);
        listaComidas.add(comida2);

        Restaurante restaurante1 = new Restaurante("039061882F", "Kebab Parsa", new Direccion("Calle del Moro", 2, 19200, "Azuqueca de Henares"), "Turca", 4.8, 0.99, 30, new Catering(false), listaComidas);
        Restaurante restaurante2 = new Restaurante("035123853H", "Domino's pizza", new Direccion("Calle Roma", 7, 28801, "Alcalá de Henares"), "Italiana", 3.9, 4.99, 30, new Catering(true), listaComidas);
        Restaurante restaurante3 = new Restaurante("029461719U", "Buda Kaioken", new Direccion("Calle dorayaki", 11, 19201, "Guadalajara"), "Asiática", 4.2, 2.99, 30, new Catering(false), listaComidas);
        listaRestaurantes.add(restaurante1);
        listaRestaurantes.add(restaurante2);
        listaRestaurantes.add(restaurante3);*/
    }



    // PARTICULAR ---------------------------------------------
    public static List<Particular> getListaParticulares() {
        return listaParticulares;
    }

    public static void setListaParticulares(List<Particular> listaParticulares) {
        Informacion.listaParticulares = listaParticulares;
    }

    public static void anadirParticular(Particular particular) {
        listaParticulares.add(particular);
    }

    public static void quitarParticular(Particular particular) {
        listaParticulares.remove(particular);
    }

    public static void guardarDatosParticular() {
        try {
            //Si hay datos los guardamos...
            if (!listaParticulares.isEmpty()) {
                try (FileOutputStream ParticularesGuardadosFichero = new FileOutputStream("Particulares.txt")) {
                    ObjectOutputStream ParticularesParaGuardar = new ObjectOutputStream(ParticularesGuardadosFichero);
                    //guardamos el array de Productos
                    ParticularesParaGuardar.writeObject(listaParticulares);
                }
            } else {
                System.out.println("Error: No hay datos de particulares...");
            }

        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        }
    }

    public static void cargarDatosParticular() {
        try {
            try (FileInputStream ParticularesGuardadosFichero = new FileInputStream("Particulares.txt")) {
                ObjectInputStream ParticularesParaCargar = new ObjectInputStream(ParticularesGuardadosFichero);
                listaParticulares = (ArrayList) ParticularesParaCargar.readObject();
                for (Particular particular : listaParticulares) {
                    System.out.println(particular);

                }
            }
        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error de clase no encontrada: " + cnfe.getMessage());
        }
    }

    // EMPRESAS ----------------------------------------
    public static List<Empresa> getListaEmpresas() {
        return listaEmpresas;
    }

    public static void setListaEmpresas(List<Empresa> listaEmpresas) {
        Informacion.listaEmpresas = listaEmpresas;
    }

    public static void anadirEmpresa(Empresa empresa) {
        listaEmpresas.add(empresa);
    }

    public static void quitarEmpresa(Empresa empresa) {
        listaEmpresas.remove(empresa);
    }

    public static void guardarDatosEmpresa() {
        try {
            //Si hay datos los guardamos...
            if (!listaEmpresas.isEmpty()) {
                try (FileOutputStream EmpresasGuardadosFichero = new FileOutputStream("Empresas.txt")) {
                    ObjectOutputStream EmpresasParaGuardar = new ObjectOutputStream(EmpresasGuardadosFichero);
                    //guardamos el array de Productos
                    EmpresasParaGuardar.writeObject(listaEmpresas);
                }
            } else {
                System.out.println("Error: No hay datos de empresas...");
            }

        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        }
    }

    public static void cargarDatosEmpresa() {
        try {
            try (FileInputStream EmpresasGuardadosFichero = new FileInputStream("Empresas.txt")) {
                ObjectInputStream EmpresasParaCargar = new ObjectInputStream(EmpresasGuardadosFichero);
                listaEmpresas = (ArrayList) EmpresasParaCargar.readObject();
                for (Empresa empresa : listaEmpresas) {
                    System.out.println(empresa);

                }
            }
        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error de clase no encontrada: " + cnfe.getMessage());
        }
    }

    //RESTAURANTE -----------------------------------------------------
    public static List<Restaurante> getListaRestaurantes() {
        return listaRestaurantes;
    }

    public static void setRestaurantes(List<Restaurante> r) {
        listaRestaurantes = r;
    }

    public static void anadirRestaurante(Restaurante restaurante) {
        listaRestaurantes.add(restaurante);
    }

    public static void quitarRestaurante(Restaurante restaurante) {
        listaRestaurantes.remove(restaurante);
    }

    public static void guardarDatosRestaurante() {
        try {
            //Si hay datos los guardamos...
            if (!listaRestaurantes.isEmpty()) {
                try (FileOutputStream restaurantesGuardadosFichero = new FileOutputStream("Restaurantes.txt")) {
                    ObjectOutputStream restaurantesParaGuardar = new ObjectOutputStream(restaurantesGuardadosFichero);
                    //guardamos el array de Productos
                    restaurantesParaGuardar.writeObject(listaRestaurantes);
                }
            } else {
                System.out.println("Error: No hay datos de restaurantes.");
            }

        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        }
    }//fin guardarDatos

    public static void cargarDatosRestaurante() {
        try {
            try (FileInputStream RestaurantesCargadosFichero = new FileInputStream("Restaurantes.txt")) {
                ObjectInputStream RestaurantesParaCargar = new ObjectInputStream(RestaurantesCargadosFichero);
                listaRestaurantes = (ArrayList) RestaurantesParaCargar.readObject();
                for (Restaurante restaurante : listaRestaurantes) {
                    System.out.println(restaurante);

                }
            }
        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error de clase no encontrada: " + cnfe.getMessage());
        }

    }//fin cargarDatos

    public static void setListaComidas(ArrayList<Comida> listaComidas) {
        Informacion.listaComidas = listaComidas;
    }

    public static ArrayList<Comida> getListaComidas() {
        return listaComidas;
    }

    public static void anadirComida(Comida comida) {
        listaComidas.add(comida);
    }

    public static void quitarComida(Comida comida) {
        listaComidas.remove(comida);
    }

    public static void guardarDatosComida() {
        try {
            //Si hay datos los guardamos...
            if (!listaComidas.isEmpty()) {
                try (FileOutputStream comidasGuardadosFichero = new FileOutputStream("Comidas.txt")) {
                    ObjectOutputStream comidasParaGuardar = new ObjectOutputStream(comidasGuardadosFichero);
                    //guardamos el array de Productos
                    comidasParaGuardar.writeObject(listaComidas);
                }
            } else {
                System.out.println("Error: No hay datos de comida...");
            }

        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        }
    }//fin guardarDatos

    public static void cargarDatosComida() {
        try {
            try (FileInputStream ComidasCargadosFichero = new FileInputStream("Comidas.txt")) {
                ObjectInputStream ComidasParaCargar = new ObjectInputStream(ComidasCargadosFichero);
                listaComidas = (ArrayList) ComidasParaCargar.readObject();
                for (Comida comida : listaComidas) {
                    System.out.println(comida);

                }
            }
        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error de clase no encontrada: " + cnfe.getMessage());
        }
    }

    // LISTA COMIDAS
    public static void guardarDatos() {
        guardarDatosParticular();
        guardarDatosEmpresa();
        guardarDatosRestaurante();
        guardarDatosComida();
    }

    public static void cargarDatos() {
        cargarDatosParticular();
        cargarDatosEmpresa();
        cargarDatosRestaurante();
        cargarDatosComida();
    }

}
