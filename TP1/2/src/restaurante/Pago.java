package restaurante;

public class Pago {
    private final Pedido pedido;
    private final Tarjeta tarjeta;
    private final Propina propina;

    public Pago(Pedido pedido, Tarjeta tarjeta, Propina propina){
        this.pedido = pedido;
        this.tarjeta = tarjeta;
        this.propina = propina;
    }

    public double calcularTotal(){
        double subtotal = pedido.calcularSubtotal();
        double descuento = tarjeta.calcularDescuento(pedido);
        double base = subtotal - descuento;
        double propinaMonto = base * propina.getPorcentaje();
        return base + propinaMonto;
    }
}
