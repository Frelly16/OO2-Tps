package punto3.restaurante.modelo;

import punto3.restaurante.logger.RestauranteLogger;
import punto3.restaurante.tarjeta.Tarjeta;

import java.time.LocalDateTime;

public class Pago {
    private final Pedido pedido;
    private final Tarjeta tarjeta;
    private final Propina propina;
    private final RestauranteLogger logger;

    public Pago(Pedido pedido, Tarjeta tarjeta, Propina propina, RestauranteLogger logger){
        this.pedido = pedido;
        this.tarjeta = tarjeta;
        this.propina = propina;
        this.logger = logger;
    }

    public double calcularTotal(){
        double subtotal = pedido.calcularSubtotal();
        double descuento = tarjeta.calcularDescuento(pedido);
        double base = subtotal - descuento;
        double propinaMonto = base * propina.getPorcentaje();
        double total = base + propinaMonto;

        logger.registrar(LocalDateTime.now(), total);

        return total;
    }
}
