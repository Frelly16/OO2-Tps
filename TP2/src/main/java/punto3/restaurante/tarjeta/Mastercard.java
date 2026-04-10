package punto3.restaurante.tarjeta;

import punto3.restaurante.modelo.Pedido;
import punto3.restaurante.modelo.TipoItem;

public class Mastercard implements Tarjeta {
    @Override
    public double calcularDescuento(Pedido pedido) {
        return pedido.getItems().stream()
                .filter(i -> i.getTipo() == TipoItem.PLATO)
                .mapToDouble(i -> i.getPrecio() * 0.02).sum();
    }
}