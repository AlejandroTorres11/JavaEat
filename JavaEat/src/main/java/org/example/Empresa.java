package org.example;

public class Empresa extends Cliente{
    private String cif;
    private String web;

    public Empresa(String nombre, String cif, String correo, String clave, Direccion direccion, TarjetaCredito tarjeta,  String web) {
        super(nombre, correo, clave, direccion, tarjeta);
        this.cif = cif;
        this.web = web;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    @Override
    public TarjetaCredito getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(TarjetaCredito tarjeta) {
        this.tarjeta = tarjeta;
    }

   
}
