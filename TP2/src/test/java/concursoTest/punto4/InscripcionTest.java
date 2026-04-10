package concursoTest.punto4;

import org.junit.jupiter.api.Test;
import punto4.concurso.modelo.Inscripcion;
import punto4.concurso.modelo.Participante;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InscripcionTest {

    @Test
    public void testInscripcionDentroDeRango() throws InterruptedException {
        FakeArchivoInscripcionLogger fakeLogger = new FakeArchivoInscripcionLogger();
        FakeEmailService fakeEmail = new FakeEmailService();

        Inscripcion inscripcion = new Inscripcion(LocalDate.now(), LocalDate.now().plusDays(5),
                "ConcursoTest", fakeLogger, fakeEmail);

        Participante test = new Participante("Carlos", "12504839", "carlos500@ejemplo.com");
        inscripcion.inscribirParticipante(test, LocalDate.now());

        assertTrue(inscripcion.getInscriptos().contains(test));
        assertEquals(1, fakeLogger.getRegistros().size());
        assertEquals(1, fakeEmail.getEnviados().size());
    }
}
