package Strategy.ejercicio2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonaTest {

    @Test
    @DisplayName("El formato corto devuelve la fecha separada por guiones")
    public void fechaNacimiento_conFormatoCorto() {
        LocalDate fecha = LocalDate.of(1986, 6, 3);
        Persona persona = new Persona(fecha, new FormatoCorta());

        String resultado = persona.fechaNacimiento();

        assertEquals("3-06-1986", resultado);
    }

    @Test
    @DisplayName("El formato largo devuelve la fecha escrita con el mes en texto capitalizado")
    public void fechaNacimiento_conFormatoLargo() {
        LocalDate fecha = LocalDate.of(1986, 6, 3);
        Persona persona = new Persona(fecha, new FormatoLarga());

        String resultado = persona.fechaNacimiento();

        assertEquals("3 de Junio de 1986", resultado);
    }
}