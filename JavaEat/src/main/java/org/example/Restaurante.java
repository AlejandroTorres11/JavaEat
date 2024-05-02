package org.example;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Restaurante implements Serializable {

    private String cif;
    private String nombre;
    private Direccion direccion;
    private String especialidad;
    private double calificacion;
    private double gastosEnvio;
    private int tiempoEnvio;
    private Catering catering;
    private List<Comida> listaComidas;
    private double sumaCalificaciones;
    private int numeroResenas;

    public Restaurante(String cif, String nombre, Direccion direccion, String especialidad, double calificacion,
            double gastosEnvio, int tiempoEnvio, Catering catering, List<Comida> listaComidas, Double sumaCalificaciones, int numeroResenas) {
        this.cif = cif;
        this.nombre = nombre;
        this.direccion = direccion;
        this.especialidad = especialidad;
        this.calificacion = calificacion;
        this.gastosEnvio = gastosEnvio;
        this.tiempoEnvio = tiempoEnvio;
        this.catering = catering;
        this.listaComidas = listaComidas;
        this.sumaCalificaciones = sumaCalificaciones;
        this.numeroResenas = numeroResenas;
    }

    public void actualizarRestaurante(String cif, String nombre, Direccion direccion, String especialidad, double calificacion,
            double gastosEnvio, int tiempoEnvio, Catering catering, List<Comida> listaComidas) {
        this.cif = cif;
        this.nombre = nombre;
        this.direccion = direccion;
        this.especialidad = especialidad;
        this.calificacion = calificacion;
        this.gastosEnvio = gastosEnvio;
        this.tiempoEnvio = tiempoEnvio;
        this.catering = catering;
        this.listaComidas = listaComidas;
        

    }

    public double getSumaCalificaciones() {
        return sumaCalificaciones;
    }

    public void setSumaCalificaciones(double sumaCalificaciones) {
        this.sumaCalificaciones = sumaCalificaciones;
    }

    public int getNumeroResenas() {
        return numeroResenas;
    }

    public void setNumeroResenas(int numeroResenas) {
        this.numeroResenas = numeroResenas;
    }

    public void agregarComida(Comida comida) {
        listaComidas.add(comida);
    }

    public List<Comida> getListaComidas() {
        return listaComidas;
    }

    public void setListaComidas(List<Comida> listaComidas) {
        this.listaComidas = listaComidas;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }

    public double getGastosEnvio() {
        return gastosEnvio;
    }

    public void setGastosEnvio(double gastosEnvio) {
        this.gastosEnvio = gastosEnvio;
    }

    public int getTiempoEnvio() {
        return tiempoEnvio;
    }

    public void setTiempoEnvio(int tiempoEnvio) {
        this.tiempoEnvio = tiempoEnvio;
    }

    public Catering getCatering() {
        return catering;
    }

    public void setCatering(Catering catering) {
        this.catering = catering;
    }

    public void agregarReseña(double calificacion) {
        sumaCalificaciones += calificacion;
        numeroResenas++;
    }
    public double obtenerCalificacionPromedio() {
    if (numeroResenas == 0) {
        return 0.0;  // Si no hay reseñas, retorna 0 como calificación promedio.
    }
    
    double promedio = sumaCalificaciones / numeroResenas;
    
    DecimalFormat df = new DecimalFormat("#.##"); // Formato para dos decimales
    
    // Redondear el promedio a dos decimales
    String promedioRedondeadoStr = df.format(promedio);
    
    return Double.parseDouble(promedioRedondeadoStr);
}

    @Override
    public String toString() {
        return "\n nombre=" + nombre + "cif=" + cif + ", direccion=" + direccion + "\n especialidad=" + especialidad + "\n calificacion=" + calificacion + "\n gastosEnvio=" + gastosEnvio + "\n tiempoEnvio=" + tiempoEnvio + "\n catering=" + catering;
    }

}
