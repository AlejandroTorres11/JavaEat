package org.example;

import java.io.Serializable;

public class Comida implements Serializable {
    private String titulo;
    private String ingredientes;
    private Double precioVenta;
    private int cantidad;
    public Comida(String titulo, String Ingredientes, Double precioVenta) {
        this.titulo = titulo;
        this.ingredientes = Ingredientes;
        this.precioVenta = precioVenta;
        this.cantidad=1;
    }

    

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return  titulo +"," + ingredientes+ "," +precioVenta+"€" ;
                
                
                
                
    }
}

