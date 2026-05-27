package ejercicio2;

public class Spike implements ItemTrabajo {
    private final int tiempo;

    public Spike(int tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public int calcularTiempo() {
        return tiempo;
    }
}