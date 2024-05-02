/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author Alejandro Torres
 */
public class Venta {
    
    private Restaurante restaurante;
    private ArrayList<Comida> comidasCompradas;
    private LocalDateTime fechaHoraVenta = LocalDateTime.now();
    private DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private String nombreCliente;
    private Direccion direccionCliente;
    private String correoCliente;
    private String numeroTarjeta;

    public Venta(Restaurante restaurante, ArrayList<Comida> comidasCompradas, String nombreCliente, Direccion direccionCliente, String correoCliente, String numeroTarjeta) {
        this.restaurante = restaurante;
        this.comidasCompradas = comidasCompradas;
        this.nombreCliente = nombreCliente;
        this.direccionCliente = direccionCliente;
        this.correoCliente = correoCliente;
        this.numeroTarjeta = numeroTarjeta;
    }
    
    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public ArrayList<Comida> getComidasCompradas() {
        return comidasCompradas;
    }

    public void setComidasCompradas(ArrayList<Comida> comidasCompradas) {
        this.comidasCompradas = comidasCompradas;
    }

    public LocalDateTime getFechaHoraVenta() {
        return fechaHoraVenta;
    }

    public void setFechaHoraVenta(LocalDateTime fechaHoraVenta) {
        this.fechaHoraVenta = fechaHoraVenta;
    }

    public DateTimeFormatter getFormateador() {
        return formateador;
    }

    public void setFormateador(DateTimeFormatter formateador) {
        this.formateador = formateador;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Direccion getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(Direccion direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    /*Generar una factura de venta en un fichero de texto: Deberá incluir la fecha de
    venta, los datos del restaurante y las comidas compradas, su cantidad y datos del
    cliente.
    Almacenar los datos de la venta: Fecha de la venta, los datos del restaurante y las
    comidas compradas, su cantidad y datos del cliente.*/
    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    @Override
    public String toString() {
        return """
               Datos de la venta:
               restaurante: """ + restaurante + "\n comidasCompradas:" + comidasCompradas + "\n fechaHoraVenta=" + fechaHoraVenta + "\n formateador=" + formateador + "\n nombreCliente=" + nombreCliente + "\n direccionCliente=" + direccionCliente + "\n correoCliente=" + correoCliente + "\n numeroTarjeta=" + numeroTarjeta;
    }

    

    
}
