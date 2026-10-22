package Monitores.Buffer;

public class MainBuffer {
    private static BufferFIFO buffer = new BufferFIFO(2);
    private static Productor productor = new Productor(buffer);
    private static Consumidor consumidor = new Consumidor(buffer);

    public static void main(String[] args) throws Exception {
        productor.start();
        consumidor.run();
    }
}
