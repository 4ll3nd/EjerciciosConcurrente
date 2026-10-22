package Monitores.ThreadPool;

public class PoisonPill implements Runnable{
    @Override
    public void run() {
        throw new PoisonException("Se Terminaron Las Tareas");
    }
}
