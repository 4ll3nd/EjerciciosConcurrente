package Monitores.ThreadPool;

public class BufferTareas {
    Runnable[] datos;
    int fin;
    int inicio;
    int cantEspacios;

    public BufferTareas(int dimension) {
        this.datos = new Runnable[dimension + 1];
        this.fin = 0;
        this.inicio = 0;
        this.cantEspacios = dimension;
    }

    public synchronized Runnable consumir() throws Exception{
        while(this.inicio == this.fin) {wait();}
        Runnable aux = this.datos[this.fin];
        this.fin = this.next(this.fin);
        notifyAll();
        return aux;
    }

    public synchronized void producir(Runnable task) throws Exception{
        while(this.next(this.inicio) == this.fin) {wait();}
        this.datos[inicio] = task;
        inicio = next(inicio);
        notifyAll();
    }

    public boolean isEmpty() {
        return inicio == fin;
    }

    private int next(int i) {
        return (i+1) % (this.cantEspacios + 1);
    }
}
