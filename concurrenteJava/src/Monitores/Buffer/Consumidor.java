package Monitores.Buffer;

public class Consumidor extends Thread {
    private BufferFIFO buffer;

    public Consumidor(BufferFIFO buffer) {
        this.buffer = buffer;
    }

    public void run() {
        while(true) {
            try {
                System.out.println("leido: " + buffer.consumir());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
