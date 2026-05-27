package ejercicio5;

import ejercicio5.modelo.Concurso;
import ejercicio5.modelo.Inscripcion;
import ejercicio5.modelo.NotificadorEmailDecorador;
import ejercicio5.modelo.Participante;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class InscripcionConcursoTest {
    @Test
    @DisplayName("El decorador inscribe al participante correctamente en la lista y dispara el envío del email")
    public void inscribirParticipante_decorador_guardaEnListaYEnviaNotificacion() throws InterruptedException {

        FakeEmailService fakeEmail = new FakeEmailService();
        FakeLogger fakeLogger = new FakeLogger();
        String idConcurso = "Concurso2026";

        LocalDate hoy = LocalDate.now();
        LocalDate fechaCierre = hoy.plusDays(5);

        Inscripcion inscripcionBase = new Inscripcion(hoy, fechaCierre, idConcurso, fakeLogger);
        Concurso concursoDecorado = new NotificadorEmailDecorador(inscripcionBase, fakeEmail, idConcurso);

        Participante participante = new Participante("Ana", "12345678", "ana@test.com");

        concursoDecorado.inscribirParticipante(participante, hoy);

        assertTrue(inscripcionBase.getInscriptos().contains(participante));
        assertTrue(fakeLogger.logFueLlamado);
        assertEquals("ana@test.com", fakeEmail.destinatarioRegistrado);
        assertEquals("Confirmación de inscripción", fakeEmail.asuntoRegistrado);
    }
}