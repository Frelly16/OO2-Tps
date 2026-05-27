package ejercicio4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PedidoRestauranteTest {

    @Test
    @DisplayName("Armado de Combo 1: Básico con Tomate y Queso")
    public void armarComboUno_basicoConTomateYQueso() {
        Combo pedido = new PedidoBuilder(new ComboBasico())
                .agregarTomate()
                .agregarQueso()
                .finalizarPedido();

        // Basico 5000 + Tomate 500 + Queso 800 = 6300
        assertEquals("Combo Básico + Tomate + Queso", pedido.descripcion());
        assertEquals(6300.0, pedido.precio());
    }

    @Test
    @DisplayName("Armado de Combo 2: Especial con Carne y Papas dobles")
    public void armarComboDos_especialConCarneYPapasDobles() {
        Combo pedido = new PedidoBuilder(new ComboEspecial())
                .agregarCarne()
                .agregarPapas()
                .agregarPapas()
                .finalizarPedido();

        // Especial 10000 + Carne 2000 + Papas 1000 + Papas 1000 = 14000
        assertEquals("Combo Especial + Carne + Papas + Papas", pedido.descripcion());
        assertEquals(14000.0, pedido.precio());
    }
}