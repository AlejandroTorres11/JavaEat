/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

import java.io.Serializable;

/**
 *
 * @author david
 */
public class TarjetaCredito implements Serializable{

    private int numeroTarjeta;
    private String fechaExpiracion;
    private int codigoSeguridad;

    // Constructor
    public TarjetaCredito(int numeroTarjeta, String fechaExpiracion, int codigoSeguridad) {
        this.numeroTarjeta = numeroTarjeta;
        this.fechaExpiracion = fechaExpiracion;
        this.codigoSeguridad = codigoSeguridad;

    }

    // Métodos getter y setter para acceder y modificar los atributos
    public int getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(int numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(String fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public int getCodigoSeguridad() {
        return codigoSeguridad;
    }

    public void setCodigoSeguridad(int codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }

    @Override
    public String toString() {
        return "numero:"+numeroTarjeta + ", expira: " + fechaExpiracion + ", cvv: " + codigoSeguridad;
    }
    
}
