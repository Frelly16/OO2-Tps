package test;

import org.testng.annotations.Test;
import restaurante.MenuItem;
import restaurante.Mesa;
import restaurante.Pedido;
import restaurante.TipoItem;

import static org.testng.Assert.assertThrows;
import static org.testng.AssertJUnit.assertEquals;

public class MesaTest {

    @Test
    void agregarPedidoHastaCapacidad(){
        Mesa mesa = new Mesa(1, 2);
        Pedido p1 = new Pedido();
        p1.agregarItem(new MenuItem("Agua", 3500, TipoItem.BEBIDA));
        Pedido p2 = new Pedido();
        p2.agregarItem(new MenuItem("Pizza", 15000, TipoItem.PLATO));

        mesa.agregarPedido(p1);
        mesa.agregarPedido(p2);

        assertEquals(2, mesa.getPedidos().size());
    }

    @Test
    void maximosPedidosSuperados(){
        Mesa mesa = new Mesa(1, 1);
        Pedido p1 = new Pedido();
        Pedido p2 = new Pedido();

        mesa.agregarPedido(p1);
        assertThrows(IllegalStateException.class, () -> mesa.agregarPedido(p2));
    }
}
