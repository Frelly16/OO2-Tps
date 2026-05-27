package ejercicio4;

import java.time.LocalDate;
import java.time.Month;

public abstract class CalculadorPrecioTemplate implements Calculador {
    private final int mesEnPromocion;
    private final LogTransaction log;

    public CalculadorPrecioTemplate(int mesEnPromocion, LogTransaction log) {
        this.mesEnPromocion = mesEnPromocion;
        this.log = log;
    }

    @Override
    public final double calcularPrecio(double precioProducto) {
        double precioTotal = precioProducto + (precioProducto * recargoCorrespondiente());

        log.log(this.getClass().getName());

        return precioTotal;
    }

    private double recargoCorrespondiente() {
        if (Month.of(mesEnPromocion).equals(LocalDate.now().getMonth())) {
            return recargoEnPromocion();
        }
        return recargoFueraDePromocion();
    }

    protected abstract double recargoEnPromocion();
    protected abstract double recargoFueraDePromocion();
}