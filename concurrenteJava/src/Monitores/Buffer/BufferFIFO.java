package Monitores.Buffer;

import java.sql.Array;

public class BufferFIFO {
    int[] datos;
    int fin;
    int inicio;
    int cantEspacios;
    public BufferFIFO(int dimension) {
        this.datos = new int[dimension + 1];
        this.fin = 0;
        this.inicio = 0;
        this.cantEspacios = dimension;
    }

    public synchronized int consumir() throws Exception{
        while(this.inicio == this.fin) {wait();}
        int aux = this.datos[this.fin];
        this.fin = this.next(this.fin);
        notifyAll();
        return aux;
    }

    public synchronized void producir(int numero) throws Exception{
        while(this.next(this.inicio) == this.fin) {wait();}
        this.datos[inicio] = numero;
        inicio = next(inicio);
        notifyAll();
    }

    private int next(int i) {
        return (i+1) % (this.cantEspacios + 1);
    }
}
