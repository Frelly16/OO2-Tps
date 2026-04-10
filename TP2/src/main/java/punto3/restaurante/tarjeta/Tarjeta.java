package punto3.restaurante.tarjeta;

import punto3.restaurante.modelo.Pedido;

public interface Tarjeta {
    double calcularDescuento(Pedido pedido);
}
