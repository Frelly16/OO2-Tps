package ejercicio5;

public class RemeraNacional extends Remera {
    private static final double COSTO_TRANSPORTE = 0.015;
    private static final double BONIFICACION = 0.20;
    private static final double GANANCIA_COMERCIO = 0.15;

    public RemeraNacional(double precioUnitario) {
        super(precioUnitario);
    }

    @Override
    protected double calcularAjustesEspecificos() {
        double transporte = precioUnitario * COSTO_TRANSPORTE;
        double descuento = precioUnitario * BONIFICACION;

        return transporte - descuento;
    }

    @Override
    protected double porcentajeGananciaComercio() {
        return GANANCIA_COMERCIO;
    }
}