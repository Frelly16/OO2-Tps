package Strategy.ejercicio1;

public class EnvioColectivosSur implements CalculadorEnvio {

    @Override
    public double calcularCosto(Pedido pedido) {
        return costoPorDestino(pedido.destino()) + recargoPorPeso(pedido.pesoEnKilos());
    }

    private double costoPorDestino(Destino destino) {
        if (destino == Destino.CAPITAL_FEDERAL) {
            return 1000.0;
        }
        if (destino == Destino.GRAN_BUENOS_AIRES) {
            return 1500.0;
        }
        return 3000.0;
    }

    private double recargoPorPeso(double peso) {
        if (peso > 30.0) {
            return 2000.0;
        }
        if (peso > 5.0) {
            return 500.0;
        }
        return 0.0;
    }
}