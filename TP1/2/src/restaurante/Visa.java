package restaurante;

public class Visa implements Tarjeta {
    @Override
    public double calcularDescuento(Pedido pedido) {
        return pedido.getItems().stream()
                .filter(i -> i.getTipo() == TipoItem.BEBIDA)
                .mapToDouble(i -> i.getPrecio() * 0.03).sum();
    }
}
