package ejercicio4;

public class CalculadorJubilado extends CalculadorPrecioTemplate {

    public CalculadorJubilado(int mesEnPromocion, LogTransaction log) {
        super(mesEnPromocion, log);
    }

    @Override
    protected double recargoEnPromocion() {
        return 0.0;
    }

    @Override
    protected double recargoFueraDePromocion() {
        return 0.10;
    }
}