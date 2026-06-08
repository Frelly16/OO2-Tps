package Strategy.ejercicio1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadorEnvioTest {

    @Test
    @DisplayName("Colectivos Sur a GBA con 10kg suma el fijo de GBA más recargo medio")
    public void calcular_colectivosSur_GBA_pesoMedio() {
        CalculadorEnvio envio = new EnvioColectivosSur();
        Pedido pedido = new Pedido(Destino.GRAN_BUENOS_AIRES, 10.0);

        // Fijo GBA (1500) + Recargo peso (500) = 2000
        double costo = envio.calcularCosto(pedido);

        assertEquals(2000.0, costo);
    }

    @Test
    @DisplayName("Correo Argentino al interior cobra el fijo más el recargo por distancia del servicio externo")
    public void calcular_correoArgentino_Otros_usaServicioDistancia() {
        ServicioDistancia fakeServicio = destino -> 100.0; // Simulamos 100km
        CalculadorEnvio envio = new EnvioCorreoArgentino(fakeServicio);
        Pedido pedido = new Pedido(Destino.OTROS, 2.0); // El peso no importa acá

        // Fijo Otros (800) + (100km * 5) = 1300
        double costo = envio.calcularCosto(pedido);

        assertEquals(1300.0, costo);
    }
}