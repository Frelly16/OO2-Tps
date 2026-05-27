package ejercicio2;

public class Tarea implements ItemTrabajo {
    private final int tiempo;

    public Tarea(int tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public int calcularTiempo() {
        return tiempo;
    }
}