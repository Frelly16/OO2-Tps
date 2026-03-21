package restaurante;

public class ComarcaPlus implements Tarjeta {
    @Override
    public double calcularDescuento(Pedido pedido) {
        return pedido.calcularSubtotal() * 0.02;
    }
}