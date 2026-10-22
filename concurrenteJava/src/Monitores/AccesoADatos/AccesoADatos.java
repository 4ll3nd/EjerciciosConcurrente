package Monitores.AccesoADatos;

public class AccesoADatos {
    private int lectores = 0;
    private boolean enEscritura = false;
    private int escritoresEsperando = 0;

    public synchronized void beginRead() throws InterruptedException {
        while(enEscritura || escritoresEsperando > 0) {wait();}
        this.lectores++;
    }

    public synchronized void endRead() {
        this.lectores--;
        if(lectores == 0) {
            notifyAll();
        }
    }

    public synchronized void beginWrite() throws InterruptedException {
        this.escritoresEsperando++;
        while(enEscritura || lectores > 0){wait();}
        this.escritoresEsperando--;
        this.enEscritura = true;
    }

    public synchronized void endWrite() {
        this.enEscritura = false;
        notifyAll();
    }
}
