package punto3.restaurante.tarjeta;

import punto3.restaurante.modelo.Pedido;
import punto3.restaurante.modelo.TipoItem;

public class Visa implements Tarjeta {
    @Override
    public double calcularDescuento(Pedido pedido) {
        return pedido.getItems().stream()
                .filter(i -> i.getTipo() == TipoItem.BEBIDA)
                .mapToDouble(i -> i.getPrecio() * 0.03).sum();
    }
}
