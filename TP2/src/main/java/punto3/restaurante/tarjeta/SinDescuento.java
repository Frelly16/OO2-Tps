package punto3.restaurante.tarjeta;

import punto3.restaurante.modelo.Pedido;

public class SinDescuento implements Tarjeta {
    @Override
    public double calcularDescuento(Pedido pedido) {
        return 0;
    }
}
