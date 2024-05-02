package org.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class Cliente implements Serializable {
    String nombre;
    String correo;
    String clave;
    Direccion direccion;
    TarjetaCredito tarjeta;

    public Cliente(String nombre, String correo, String clave, Direccion direccion, TarjetaCredito tarjeta) {
        this.nombre = nombre;
        this.correo = correo;
        this.clave = clave;
        this.direccion= direccion;
        this.tarjeta = tarjeta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public TarjetaCredito getTarjeta() {
        return tarjeta;
    }

    public void setNumeroTarjeta(TarjetaCredito tarjeta) {
        this.tarjeta = tarjeta;
    }

}
