package DobleDispatch.ejercicio5;

import DoubleDispatch.ejercicio5.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PrestamoTest {

    private final Persona persona = new Persona("Juan");
    private final LocalDate hoy = LocalDate.now();

    @Test
    @DisplayName("Libro usado de 250 páginas se presta por 3 días")
    public void prestamo_libro_calculaDiasPorPagina() {
        Articulo libro = new Libro(250); // 250 / 100 = 2.5 -> redondea a 3

        Prestamo prestamo = new Prestamo(persona, libro, new Usado(), hoy);

        assertEquals(hoy.plusDays(3), prestamo.fechaDevolucion());
    }

    @Test
    @DisplayName("Disco deteriorado de banda anterior a 1980 lanza excepción")
    public void prestamo_discoDeterioradoViejo_lanzaExcepcion() {
        Articulo disco = new Disco(1975);

        assertThrows(RuntimeException.class, () -> {
            new Prestamo(persona, disco, new Deteriorado(), hoy);
        });
    }

    @Test
    @DisplayName("Disco deteriorado de banda moderna resta 1 día al préstamo base de 5")
    public void prestamo_discoDeterioradoModerno_restaUnDia() {
        Articulo disco = new Disco(1990); // Base: 5 días

        Prestamo prestamo = new Prestamo(persona, disco, new Deteriorado(), hoy);

        // 5 base - 1 deterioro = 4 días
        assertEquals(hoy.plusDays(4), prestamo.fechaDevolucion());
    }

    @Test
    @DisplayName("Revista deteriorada de más de 10 años y 5000 páginas resta 3 días al préstamo base")
    public void prestamo_revistaDeterioradaAntiguaLarga_restaTresDias() {
        LocalDate hace15Anios = hoy.minusYears(15);
        Articulo revista = new Revista(5000, hace15Anios); // Base > 2000 pág: 5 días

        Prestamo prestamo = new Prestamo(persona, revista, new Deteriorado(), hoy);

        // 5 base - 3 deterioro = 2 días
        assertEquals(hoy.plusDays(2), prestamo.fechaDevolucion());
    }

    @Test
    @DisplayName("Revista nueva de 50 páginas se presta por 2 días")
    public void prestamo_revistaNuevaCorta_otorgaDiasBase() {
        Articulo revista = new Revista(50, hoy); // Base < 100 pág: 2 días

        Prestamo prestamo = new Prestamo(persona, revista, new Nuevo(), hoy);

        assertEquals(hoy.plusDays(2), prestamo.fechaDevolucion());
    }
}