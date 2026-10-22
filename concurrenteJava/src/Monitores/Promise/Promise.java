package Monitores.Promise;

public class Promise {
    private Object result = null;
    private boolean disponible = false;

    public synchronized Object await() throws InterruptedException {
        while(!disponible) {wait();}
        return result;
    }

    public synchronized void set(Object object) {
        this.result = object;
        this.disponible = true;
        notifyAll();
    }

}
