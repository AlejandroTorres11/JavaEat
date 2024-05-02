package org.example;

import java.io.Serializable;
import java.util.ArrayList;

public class CateringMenu extends Catering implements Serializable{

    public CateringMenu(boolean tieneCatering, String comidaCatering, double precio) {
        super(tieneCatering, comidaCatering, precio);
    }

    public static double precio(ArrayList<Comida> comida){
        double resultado = 0;
        for(int i=0;i<comida.size();i++){
            resultado+= comida.get(i).getPrecioVenta();
        }
        return resultado;
    }




}
