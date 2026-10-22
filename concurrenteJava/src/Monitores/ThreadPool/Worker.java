package Monitores.ThreadPool;

public class Worker extends Thread{
    private BufferTareas buffer;

    public void setBuffer(BufferTareas bufferT) {
        this.buffer = bufferT;
    }

    @Override
    public void run() {
        while (true) {
            Runnable tarea = null;
            try {
                tarea = this.buffer.consumir();
                tarea.run();
            } catch (PoisonException e) {
                System.out.println("Termine mis tareas");
            }
            catch (Exception e) {
                throw new RuntimeException();
            }
        }
    }
}
