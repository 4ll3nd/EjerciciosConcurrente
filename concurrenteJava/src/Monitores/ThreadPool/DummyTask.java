package Monitores.ThreadPool;

public class DummyTask implements Runnable{
    String tarea;

    public DummyTask(String tarea) {
        this.tarea = tarea;
    }

    @Override
    public void run() {
        System.out.println(this.tarea);
    }
}
