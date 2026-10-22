package Monitores.AccesoADatos;

import java.util.ArrayList;

public class Datos {
    ArrayList<Integer> datos = new ArrayList<>();

    public void agregarAlFinal(Integer num) {
        this.datos.addLast(num);
    }

    public ArrayList<Integer> leer() {
        return this.datos;
    }
}
