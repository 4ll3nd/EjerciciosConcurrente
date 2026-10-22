package Monitores.AccesoADatos;

import java.util.ArrayList;

public class Writter extends Thread{
    private Integer valor;
    private AccesoADatos acceso;
    private Datos datos;

    public Writter(Integer valor, AccesoADatos gestor, Datos lista) {
        this.valor = valor;
        this.acceso = gestor;
        this.datos = lista;
    }

    public void run() {
        try {
            acceso.beginWrite();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            datos.agregarAlFinal(this.valor);
        } finally {
            acceso.endWrite();
        }
    }
}
