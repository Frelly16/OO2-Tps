package ejercicio4;

public class CalculadorNoJubilado extends CalculadorPrecioTemplate {

    public CalculadorNoJubilado(int mesEnPromocion, LogTransaction log) {
        super(mesEnPromocion, log);
    }

    @Override
    protected double recargoEnPromocion() {
        return 0.15;
    }

    @Override
    protected double recargoFueraDePromocion() {
        return 0.21;
    }
}