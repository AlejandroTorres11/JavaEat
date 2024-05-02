package org.example;

public class Particular extends Cliente {

    private String dni;

    public Particular(String nombre, String dni, String correo, String clave, Direccion direccion, TarjetaCredito tarjeta) {
        super(nombre, correo, clave, direccion, tarjeta);
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }
    public String getClave() {
        return clave;
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

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public TarjetaCredito getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(TarjetaCredito tarjeta) {
        this.tarjeta = tarjeta;
    }
    
    public void setDni(String dni) {
        this.dni = dni;
    }

@Override
public String toString() {
    return "Particular{" +
            "nombre='" + nombre + '\'' +
            ", dni='" + dni + '\'' +
            ", correo='" + correo + '\'' +
            ", direccion=" + direccion +
            ", numeroTarjeta='" + tarjeta + '\'' +
            '}';
}
}

 