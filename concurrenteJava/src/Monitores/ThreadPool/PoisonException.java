package Monitores.ThreadPool;

public class PoisonException extends RuntimeException {
    public PoisonException(String message) {
        super(message);
    }
}
