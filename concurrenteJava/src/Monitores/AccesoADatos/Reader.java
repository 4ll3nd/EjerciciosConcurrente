package Monitores.AccesoADatos;

public class Reader extends Thread{
    private Datos datos;
    private AccesoADatos acceso;
    public Reader(Datos datos, AccesoADatos acceso) {
        this.datos = datos;
        this.acceso = acceso;
    }

    public void run() {
        try {
            acceso.beginRead();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for(Integer d : this.datos.leer()) {
            System.out.println(d);
        }
        acceso.endRead();
    }
}
