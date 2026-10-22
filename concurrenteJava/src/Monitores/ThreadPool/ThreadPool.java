package Monitores.ThreadPool;

import java.util.List;

public class ThreadPool {
    private BufferTareas bufferTareas;
    private List<Worker> workersOciosos;

    public ThreadPool(int capacidad, List<Worker> workers) {
        bufferTareas = new BufferTareas(capacidad);
        workersOciosos = workers;
    }

    public void iniciarWorkers() {
        for(Worker w: this.workersOciosos) {
            w.setBuffer(bufferTareas);
        }
    }
    //No es necesario synchronized porque el buffer se encarga de encolar workers(), puede pasar que un worker
    //se quede con el lock en launch lo que impide que otro pueda hacer stop o launch
    public void launch(DummyTask task) throws Exception {
        bufferTareas.producir(task);
    }

    public void stop() throws Exception {
            for(int i = 0; i < workersOciosos.size(); i++) {
                bufferTareas.producir(new PoisonPill());
        }
    }
}
