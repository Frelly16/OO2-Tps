package restauranteTest.punto3;

import org.junit.jupiter.api.Test;
import punto2.restaurante.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PagoTest {

    @Test
    void calcularTotalConVisa() {
        Pedido pedido = new Pedido();
        pedido.agregarItem(new MenuItem("Coca", 5000, TipoItem.BEBIDA));
        pedido.agregarItem(new MenuItem("Pizza", 15000, TipoItem.PLATO));

        FakeRestauranteLogger fakeLogger = new FakeRestauranteLogger();

        Tarjeta visa = new Visa();
        Pago pago = new Pago(pedido, visa, Propina.CINCO, fakeLogger);

        double total = pago.calcularTotal();
        assertEquals(20842.5, total, 0.001);
        assertEquals(1, fakeLogger.getRegistros().size());
        assertTrue(fakeLogger.getRegistros().getFirst().contains("20842.5"));
    }

    @Test
    void calcularTotalConMastercard(){
        Pedido pedido = new Pedido();
        pedido.agregarItem(new MenuItem("Coca", 5000, TipoItem.BEBIDA));
        pedido.agregarItem(new MenuItem("Pizza", 15000, TipoItem.PLATO));

        FakeRestauranteLogger fakeLogger = new FakeRestauranteLogger();

        Tarjeta masterCard = new Mastercard();
        Pago pago = new Pago(pedido, masterCard, Propina.DOS, fakeLogger);

        double total = pago.calcularTotal();
        assertEquals(20094, total, 0.001);
        assertEquals(1, fakeLogger.getRegistros().size());
        assertTrue(fakeLogger.getRegistros().getFirst().contains("20094"));
    }

    @Test
     void calcularTotalConComarcaPlus(){
        Pedido pedido = new Pedido();
        pedido.agregarItem(new MenuItem("Coca", 5000, TipoItem.BEBIDA));
        pedido.agregarItem(new MenuItem("Pizza", 15000, TipoItem.PLATO));

        FakeRestauranteLogger fakeLogger = new FakeRestauranteLogger();

        Tarjeta comarcaPlus = new ComarcaPlus();
        Pago pago = new Pago(pedido, comarcaPlus, Propina.TRES, fakeLogger);

        double total = pago.calcularTotal();
        assertEquals(20188, total, 0.001);
        assertEquals(1, fakeLogger.getRegistros().size());
        assertTrue(fakeLogger.getRegistros().getFirst().contains("20188"));
    }

    @Test
    void calcularTotalConOtraTarjeta(){
        Pedido pedido = new Pedido();
        pedido.agregarItem(new MenuItem("Pizza", 15000, TipoItem.PLATO));

        FakeRestauranteLogger fakeLogger = new FakeRestauranteLogger();

        Tarjeta otra = new SinDescuento();
        Pago pago = new Pago(pedido, otra, Propina.DOS, fakeLogger);

        double total = pago.calcularTotal();
        assertEquals(15300, total, 0.001);
        assertEquals(1, fakeLogger.getRegistros().size());
        assertTrue(fakeLogger.getRegistros().getFirst().contains("15300"));
    }
}