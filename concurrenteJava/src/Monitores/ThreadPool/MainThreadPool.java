package Monitores.ThreadPool;

import java.util.ArrayList;
import java.util.List;

public class MainThreadPool {
    public static void main(String[] args) throws Exception {
        List<Worker> workers = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            workers.add(new Worker());
        }

        ThreadPool threadPool = new ThreadPool(100, workers);

        for (int i = 0; i < 10; i++) {
            threadPool.launch(new DummyTask("tarea" + i));
        }

        threadPool.iniciarWorkers();

        for(Worker w: workers) {
            w.start();
        }

        threadPool.stop();

        for(Worker w: workers) {
            w.join();
        }
    }
}
