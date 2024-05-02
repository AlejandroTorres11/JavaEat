package org.example;

import java.io.Serializable;

public class Direccion implements Serializable{
    private int cp;
    private String calle;
    private int numero;
    private String ciudad;

    public Direccion(String calle,int numero, int cp,String ciudad) {
        this.cp = cp;
        this.calle = calle;
        this.numero = numero;
        this.ciudad = ciudad;
    }



    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
@Override
public String toString() {
    return calle + " " + numero + ", " + cp + " " + ciudad;
}

}
