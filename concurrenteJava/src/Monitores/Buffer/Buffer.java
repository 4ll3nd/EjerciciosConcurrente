package Monitores.Buffer;

public class Buffer {

    private Integer data;

    public synchronized Integer consume() throws InterruptedException {
        while(data == null) {
            wait();
        }
        Integer aux = this.data;
        this.data = null;
        notifyAll();
        return aux;
    }

    public synchronized void produce(Integer num) throws InterruptedException {
        while(data != null) {
            wait();
        }
        this.data = num;
        notifyAll();
    }
}
