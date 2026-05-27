package ejercicio1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MotorAdapterTest {

    private final ByteArrayOutputStream capturadorConsola = new ByteArrayOutputStream();
    private final PrintStream salidaOriginal = System.out;

    @BeforeEach
    public void prepararConsola() {
        System.setOut(new PrintStream(capturadorConsola));
    }

    @AfterEach
    public void restaurarConsola() {
        System.setOut(salidaOriginal);
    }

    @Test
    @DisplayName("El adaptador traduce las llamadas estándar a los mensajes del motor eléctrico")
    public void adaptadorEjecutaLogicaElectrica() {
        Motor motor = new MotorElectricoAdapter(new MotorElectrico());

        motor.arrancar();
        motor.acelerar();
        motor.apagar();

        String salida = capturadorConsola.toString();

        assertTrue(salida.contains("Conectando y activando motor eléctrico"));
        assertTrue(salida.contains("Moviendo más rápido motor eléctrico"));
        assertTrue(salida.contains("Deteniendo y desconectando motor eléctrico"));
    }

    @Test
    @DisplayName("Un motor común ejecuta sus propios mensajes sin verse afectado")
    public void motorComunEjecutaLogicaNativa() {
        Motor motor = new MotorComun();

        motor.arrancar();

        String salida = capturadorConsola.toString();

        assertTrue(salida.contains("Arrancando motor común"));
    }
}