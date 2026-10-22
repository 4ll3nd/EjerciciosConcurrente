package Test;
import Monitores.Buffer.Buffer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.*;

class BufferTest {

    @BeforeEach
    void setUp() {
        Buffer buffer = new Buffer();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testConsumeSeBloqueaSiEstaVacio() throws Exception {
        Buffer buffer = new Buffer();
        Thread consumidor = new Thread(() -> {
            try {
                buffer.consume();
            } catch (InterruptedException ignored) {}
        });

        consumidor.start();

        long limite = System.currentTimeMillis() + 1000;
        while (consumidor.getState() != Thread.State.WAITING
                && System.currentTimeMillis() < limite) {
            Thread.onSpinWait();
        }

        assertEquals(Thread.State.WAITING, consumidor.getState());

        consumidor.interrupt();
        consumidor.join();
    }

    @Test
    void testProduceConUnBufferVaciaYUnConsumidorConsume() throws Exception {
        Buffer buffer = new Buffer();
        AtomicReference<Integer> data = new AtomicReference<>();
        Thread productor = new Thread( () -> {
            try {
                buffer.produce(1);
            } catch (InterruptedException ignored) {}
        });

        Thread consumidor = new Thread( () -> {
            try {
                data.set(buffer.consume());
            } catch (InterruptedException ignored) {}
        });

        productor.start();
        consumidor.start();
        productor.join(1000);
        consumidor.join(1000);

        assertFalse(productor.isAlive());
        assertFalse(consumidor.isAlive());
        assertEquals(1, data.get());
    }

    @Test
    void testProduceConBufferLlenoYSeQuedaEsperando() throws Exception {

    }
}