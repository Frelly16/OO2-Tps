package ejercicio5;

public class RemeraImportada extends Remera {
    private static final double RECARGO_IMPORTACION = 0.03;
    private static final double IMPUESTO_ADUANERO = 0.05;
    private static final double GANANCIA_COMERCIO = 0.25;

    public RemeraImportada(double precioUnitario) {
        super(precioUnitario);
    }

    @Override
    protected double calcularAjustesEspecificos() {
        double recargo = precioUnitario * RECARGO_IMPORTACION;
        double impuesto = precioUnitario * IMPUESTO_ADUANERO;

        return recargo + impuesto;
    }

    @Override
    protected double porcentajeGananciaComercio() {
        return GANANCIA_COMERCIO;
    }
}