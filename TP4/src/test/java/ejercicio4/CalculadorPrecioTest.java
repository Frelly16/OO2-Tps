package ejercicio4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculadorPrecioTest {

    @Test
    @DisplayName("Un jubilado en mes de promoción no recibe recargo en el precio")
    public void calcularPrecio_jubiladoEnPromocion_sinRecargo() {
        int mesActual = LocalDate.now().getMonthValue();
        FakeLogTransaction fakeLog = new FakeLogTransaction();
        Calculador calculador = new CalculadorJubilado(mesActual, fakeLog);

        double precioFinal = calculador.calcularPrecio(100.0);

        assertEquals(100.0, precioFinal);
        assertTrue(fakeLog.fueLlamado);
    }

    @Test
    @DisplayName("Un cliente no jubilado fuera del mes de promoción recibe el recargo del 21%")
    public void calcularPrecio_noJubiladoFueraDePromocion_recargoCompleto() {
        int mesActual = LocalDate.now().getMonthValue();
        int mesDiferente = (mesActual % 12) + 1;
        FakeLogTransaction fakeLog = new FakeLogTransaction();
        Calculador calculador = new CalculadorNoJubilado(mesDiferente, fakeLog);

        double precioFinal = calculador.calcularPrecio(100.0);

        assertEquals(121.0, precioFinal);
        assertTrue(fakeLog.fueLlamado);
    }
}