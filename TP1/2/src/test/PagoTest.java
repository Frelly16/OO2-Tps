package test;

import org.testng.annotations.Test;
import restaurante.*;

import static org.testng.AssertJUnit.assertEquals;

public class PagoTest {

    @Test
    void calcularTotalConVisa() {
        Pedido pedido = new Pedido();
        pedido.agregarItem(new MenuItem("Coca", 5000, TipoItem.BEBIDA));
        pedido.agregarItem(new MenuItem("Pizza", 15000, TipoItem.PLATO));

        Tarjeta visa = new Visa();
        Pago pago = new Pago(pedido, visa, Propina.CINCO);

        double total = pago.calcularTotal();
        assertEquals(20842.5, total, 0.001);
    }

    @Test
    void calcularTotalConMastercard(){
        Pedido pedido = new Pedido();
        pedido.agregarItem(new MenuItem("Coca", 5000, TipoItem.BEBIDA));
        pedido.agregarItem(new MenuItem("Pizza", 15000, TipoItem.PLATO));

        Tarjeta masterCard = new Mastercard();
        Pago pago = new Pago(pedido, masterCard, Propina.DOS);

        double total = pago.calcularTotal();
        assertEquals(20094, total, 0.001);
    }

    @Test
    void calcularTotalConComarcaPlus(){
        Pedido pedido = new Pedido();
        pedido.agregarItem(new MenuItem("Coca", 5000, TipoItem.BEBIDA));
        pedido.agregarItem(new MenuItem("Pizza", 15000, TipoItem.PLATO));

        Tarjeta comarcaPlus = new ComarcaPlus();
        Pago pago = new Pago(pedido, comarcaPlus, Propina.TRES);

        double total = pago.calcularTotal();
        assertEquals(20188, total, 0.001);
    }

    @Test
    void calcularTotalConOtraTarjeta(){
        Pedido pedido = new Pedido();
        pedido.agregarItem(new MenuItem("Pizza", 15000, TipoItem.PLATO));

        Tarjeta otra = new SinDescuento();
        Pago pago = new Pago(pedido, otra, Propina.DOS);

        double total = pago.calcularTotal();
        assertEquals(15300, total, 0.001);
    }
}