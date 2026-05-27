package ejercicio5;

public abstract class Remera {
    protected final double precioUnitario;

    public Remera(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public final double calcularPrecioVenta() {
        double precioConAjustes = precioUnitario + calcularAjustesEspecificos();

        return precioConAjustes * (1.0 + porcentajeGananciaComercio());
    }

    protected abstract double calcularAjustesEspecificos();
    protected abstract double porcentajeGananciaComercio();
}