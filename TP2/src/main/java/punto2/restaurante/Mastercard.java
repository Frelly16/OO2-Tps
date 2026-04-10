package punto2.restaurante;

public class Mastercard implements Tarjeta {
    @Override
    public double calcularDescuento(Pedido pedido) {
        return pedido.getItems().stream()
                .filter(i -> i.getTipo() == TipoItem.PLATO)
                .mapToDouble(i -> i.getPrecio() * 0.02).sum();
    }
}