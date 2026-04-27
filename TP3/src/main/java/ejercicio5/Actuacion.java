package ejercicio5;

public abstract class Actuacion {
    protected String nombreEvento;
    protected int numeroEspectadores;

    public Actuacion(String nombreEvento, int numeroEspectadores) {
        this.nombreEvento = nombreEvento;
        this.numeroEspectadores = numeroEspectadores;
    }

    public abstract float calcularMonto();

    public String nombreEvento() {
        return this.nombreEvento;
    }
    public int numeroEspectadores() {
        return this.numeroEspectadores;
    }
    public float calcularCredito() {
        return (float) Math.max(this.numeroEspectadores() - 30, 0);
    }
}