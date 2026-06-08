package Observer.ejercicio1y2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MedidorObserverTest {

    @Test
    @DisplayName("Si la lectura es menor a 12 grados, el observador enciende la caldera")
    public void leerTemperatura_menorA12_enciendeCaldera() {
        ClimaOnline fakeClimaFrio = () -> "10.5 c";
        Medidor medidor = new Medidor(fakeClimaFrio);
        medidor.agregarObservador(new ControladorClimatizacion());

        ByteArrayOutputStream salidaConsola = interceptarConsola();

        medidor.leerTemperatura();

        assertTrue(salidaConsola.toString().contains("Hace frio, se encenderá la caldera"));
        restaurarConsola();
    }

    @Test
    @DisplayName("Si la lectura es mayor a 17 grados, el observador enciende el aire acondicionado")
    public void leerTemperatura_mayorA17_enciendeAire() {
        ClimaOnline fakeClimaCaluroso = () -> "25.0 c";
        Medidor medidor = new Medidor(fakeClimaCaluroso);
        medidor.agregarObservador(new ControladorClimatizacion());

        ByteArrayOutputStream salidaConsola = interceptarConsola();

        medidor.leerTemperatura();

        assertTrue(salidaConsola.toString().contains("Hace calor, se encenderá el aire acondicionado"));
        restaurarConsola();
    }

    // --- Métodos de utilidad para testear System.out ---
    private final PrintStream salidaOriginal = System.out;
    private ByteArrayOutputStream capturador;

    private ByteArrayOutputStream interceptarConsola() {
        capturador = new ByteArrayOutputStream();
        System.setOut(new PrintStream(capturador));
        return capturador;
    }

    private void restaurarConsola() {
        System.setOut(salidaOriginal);
    }
}