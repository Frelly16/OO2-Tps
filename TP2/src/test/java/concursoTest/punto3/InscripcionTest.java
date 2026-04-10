package concursoTest.punto3;

import punto1.concurso.Inscripcion;
import punto1.concurso.Participante;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class InscripcionTest {

    @Test
    void inscribirParticipanteDentroDelRango() {
        LocalDate apertura = LocalDate.now();
        LocalDate cierre = apertura.plusDays(5);
        FakeInscripcionLogger fakeLogger = new FakeInscripcionLogger();
        Inscripcion inscripcion = new Inscripcion(apertura, cierre, "Concurso2026", fakeLogger);
        Participante p1 = new Participante("Lautaro", "40100535");

        inscripcion.inscribirParticipante(p1, apertura);

        assertEquals(10, p1.verPuntos());
        assertEquals(1, fakeLogger.registros.size());
        assertTrue(fakeLogger.registros.getFirst().contains("40100535"));
    }

    @Test
    void inscripcionFueraDeRango() {
        LocalDate apertura = LocalDate.now();
        LocalDate cierre = apertura.plusDays(5);
        FakeInscripcionLogger memoryLogger = new FakeInscripcionLogger();
        Inscripcion inscripcion = new Inscripcion(apertura, cierre, "Concurso2026", memoryLogger);
        Participante p1 = new Participante("Samuel", "28150099");

        assertThrows(IllegalArgumentException.class,
                () -> inscripcion.inscribirParticipante(p1, cierre.plusDays(10)));
    }

}
