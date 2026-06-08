package Strategy.ejercicio1;

public class EnvioCorreoArgentino implements CalculadorEnvio {
    private final ServicioDistancia servicioDistancia;

    public EnvioCorreoArgentino(ServicioDistancia servicioDistancia) {
        this.servicioDistancia = servicioDistancia;
    }

    @Override
    public double calcularCosto(Pedido pedido) {
        if (pedido.destino() == Destino.CAPITAL_FEDERAL) {
            return 500.0;
        }

        double distancia = servicioDistancia.obtenerDistanciaEnKilometros(pedido.destino());
        return 800.0 + (distancia * 5.0);
    }
}