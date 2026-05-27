package ejercicio5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculoPrecioRemeraTest {

    @Test
    @DisplayName("Una remera importada suma recargo e impuesto aduanero, y aplica el 25% final")
    public void calcularPrecio_remeraImportada_aplicaImpuestosYGanancia() {
        Remera remera = new RemeraImportada(100.0);

        double precioFinal = remera.calcularPrecioVenta();

        assertEquals(135.0, precioFinal);
    }

    @Test
    @DisplayName("Una remera nacional suma transporte, resta bonificación, y aplica el 15% final")
    public void calcularPrecio_remeraNacional_aplicaBonificacionYGanancia() {
        Remera remera = new RemeraNacional(100.0);

        double precioFinal = remera.calcularPrecioVenta();

        assertEquals(93.725, precioFinal, 0.001);
    }
}