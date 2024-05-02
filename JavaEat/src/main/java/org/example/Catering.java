package org.example;

import java.io.Serializable;


    public class Catering implements Serializable {
        private String comidaCatering;
        private boolean tieneCatering;
        private double precio;

        public Catering( boolean tieneCatering,String comidaCatering, double precio) {
                this.comidaCatering = comidaCatering;
                this.tieneCatering = tieneCatering;      
                this.precio = precio;
        }

    public String getComidaCatering() {
        return comidaCatering;
    }

    public void setComidaCatering(String comidaCatering) {
        this.comidaCatering = comidaCatering;
    }

    public Catering(boolean tieneCatering) {
        this.tieneCatering = tieneCatering;
    }
    

    public boolean isTieneCatering() {
        return tieneCatering;
    }

    public void setTieneCatering(boolean tieneCatering) {
        this.tieneCatering = tieneCatering;
    }

  

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return  comidaCatering + ",Catering=" + tieneCatering +  ", precio=" + precio ;
    }
    
}
