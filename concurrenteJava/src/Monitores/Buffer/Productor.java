package Monitores.Buffer;

public class Productor extends Thread{
    private BufferFIFO buffer;

    public Productor(BufferFIFO buffer) {
        this.buffer = buffer;
    }

    public void run () {
        int i = 0;
        while(true) {
            try {
                buffer.producir(i);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            i++;
        }
    }
}
