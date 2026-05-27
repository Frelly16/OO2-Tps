package ejercicio3;

public class SeguroIndividual implements Seguro {
    private final double costoBase;

    public SeguroIndividual(double costoBase) {
        this.costoBase = costoBase;
    }

    @Override
    public double calcularCosto() {
        return costoBase;
    }

    @Override
    public int contarSeguros() {
        return 1;
    }
}