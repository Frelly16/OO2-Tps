import ejercicio2.modelo.Empleado;
import ejercicio2.modelo.GestorCumpleaños;
import ejercicio2.modelo.LectorEmpleados;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SaludoCumpleañosTest {

    @Test
    public void mensajeCumpleañosTest() {
        Empleado cumpleañero = new Empleado("TestNombre", "TestApellido", LocalDate.now(), "TestEmail@abc.com");
        LectorEmpleados fakeLector = () -> List.of(cumpleañero);
        FakeNotificador fakeNotificacion = new FakeNotificador();
        GestorCumpleaños gestor = new GestorCumpleaños(fakeLector, fakeNotificacion);

        gestor.enviarSaludo();

        assertTrue(fakeNotificacion.seEnvioMail);
        assertEquals("TestEmail@abc.com", fakeNotificacion.destinatario);
        assertEquals("¡Feliz cumpleaños TestNombre!", fakeNotificacion.mensaje);
    }

    @Test
    public void mensajeNoCumpleañosTest() {
        Empleado noCumpleañero = new Empleado("TestNombre", "TestApellido", LocalDate.now().minusMonths(4), "TestEmail@abc.com");
        LectorEmpleados fakeLector = () -> List.of(noCumpleañero);
        FakeNotificador fakeNotificacion = new FakeNotificador();
        GestorCumpleaños gestor = new GestorCumpleaños(fakeLector, fakeNotificacion);

        gestor.enviarSaludo();

        assertFalse(fakeNotificacion.seEnvioMail);
        assertEquals("", fakeNotificacion.destinatario);
    }

}
