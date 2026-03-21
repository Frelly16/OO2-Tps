package test;

import org.testng.annotations.Test;
import restaurante.MenuItem;
import restaurante.Pedido;
import restaurante.TipoItem;

import static org.testng.AssertJUnit.assertEquals;

public class PedidoTest {

    @Test
    void calcularSubtotalCorrecto(){
        Pedido pedido = new Pedido();
        pedido.agregarItem(new MenuItem("Agua", 3500, TipoItem.BEBIDA));
        pedido.agregarItem(new MenuItem("Hamburguesa", 20000, TipoItem.PLATO));

        assertEquals(23500, pedido.calcularSubtotal(), 0.001);
    }
}
