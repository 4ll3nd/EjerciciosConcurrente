package Monitores.AccesoADatos;

public class mainAccesoADatos {
    private static AccesoADatos acceso = new AccesoADatos();
    private static Datos datos = new Datos();
    private static Writter e1 = new Writter(1, acceso, datos);
    private static Writter e2 = new Writter(2, acceso, datos);
    private static Writter e3 = new Writter(3, acceso, datos);
    private static Writter e4 = new Writter(4, acceso, datos);

    private static Reader r1 = new Reader(datos, acceso);
    private static Reader r2 = new Reader(datos, acceso);
    private static Reader r3 = new Reader(datos, acceso);
    private static Reader r4 = new Reader(datos, acceso);
    private static Reader r5 = new Reader(datos, acceso);
    private static Reader r6 = new Reader(datos, acceso);
    private static Reader r7 = new Reader(datos, acceso);
    private static Reader r8 = new Reader(datos, acceso);
    private static Reader r9 = new Reader(datos, acceso);
    private static Reader r10 = new Reader(datos, acceso);

    public static void main(String[] args) throws Exception {
        e1.start();
        e2.start();
        e3.start();
        e4.start();

        r1.start();
        r2.start();
        r3.start();
        r4.start();
        r5.start();
        r6.start();
        r7.start();
        r8.start();
        r9.start();
        r10.start();
    }
}
