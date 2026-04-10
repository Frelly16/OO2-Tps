package punto3.restaurante.tarjeta;

import punto3.restaurante.modelo.Pedido;

public class ComarcaPlus implements Tarjeta {
    @Override
    public double calcularDescuento(Pedido pedido) {
        return pedido.calcularSubtotal() * 0.02;
    }
}