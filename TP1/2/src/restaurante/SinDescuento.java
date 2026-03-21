package restaurante;

public class SinDescuento implements Tarjeta{
    @Override
    public double calcularDescuento(Pedido pedido) {
        return 0;
    }
}
