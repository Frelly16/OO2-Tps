package DobleDispatch.ejercicio1;

import DoubleDispatch.ejercicio1.Jugada;
import DoubleDispatch.ejercicio1.Papel;
import DoubleDispatch.ejercicio1.Piedra;
import DoubleDispatch.ejercicio1.Tijera;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadaTest {

    @Test
    void testPiedraLeGanaATijera() {
        String resultado = new Jugada().jugar(new Piedra(), new Tijera());
        assertEquals(Jugada.GANASTE, resultado);
    }

    @Test
    void testPiedraPierdeConPapel() {
        String resultado = new Jugada().jugar(new Piedra(), new Papel());
        assertEquals(Jugada.PERDISTE, resultado);
    }

    @Test
    void testPiedraEmpataConPiedra() {
        String resultado = new Jugada().jugar(new Piedra(), new Piedra());
        assertEquals(Jugada.EMPATE, resultado);
    }

    @Test
    void testPapelEmpataConPapel() {
        String resultado = new Jugada().jugar(new Papel(), new Papel());
        assertEquals(Jugada.EMPATE, resultado);
    }

    @Test
    void testPapelPierdeConTijera() {
        String resultado = new Jugada().jugar(new Papel(), new Tijera());
        assertEquals(Jugada.PERDISTE, resultado);
    }

    @Test
    void testPapelLeGanaAPiedra() {
        String resultado = new Jugada().jugar(new Papel(), new Piedra());
        assertEquals(Jugada.GANASTE, resultado);
    }

    @Test
    void testTijeraEmpataConTijera() {
        String resultado = new Jugada().jugar(new Tijera(), new Tijera());
        assertEquals(Jugada.EMPATE, resultado);
    }

    @Test
    void testTijeraPierdeConPiedra() {
        String resultado = new Jugada().jugar(new Tijera(), new Piedra());
        assertEquals(Jugada.PERDISTE, resultado);
    }

    @Test
    void testTijeraLeGanaAPapel() {
        String resultado = new Jugada().jugar(new Tijera(), new Papel());
        assertEquals(Jugada.GANASTE, resultado);
    }
}