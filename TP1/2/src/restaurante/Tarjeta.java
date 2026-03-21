package restaurante;

public class Tarjeta {
    private final TipoTarjeta tipo;

    public Tarjeta(TipoTarjeta tipo) {
        this.tipo = tipo;
    }

    public double calcularDescuento(Pedido pedido){
        return switch (tipo) {
            case VISA -> pedido.getItems().stream()
                    .filter(i -> i.getTipo() == TipoItem.BEBIDA)
                    .mapToDouble(i -> i.getPrecio() * 0.03).sum();
            case MASTERCARD -> pedido.getItems().stream()
                    .filter(i -> i.getTipo() == TipoItem.PLATO)
                    .mapToDouble(i -> i.getPrecio() * 0.02).sum();
            case COMARCA_PLUS -> pedido.calcularSubtotal() * 0.02;
            default -> 0;
        };
    }
}
