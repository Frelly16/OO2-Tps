package concursoTest;

import punto1.concurso.ArchivoInscripcionLogger;
import punto1.concurso.Inscripcion;
import punto1.concurso.Participante;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArchivoInscripcionLoggerTest {
    @Test
    void escribirArchivoCorrectamente() throws IOException {
        Path archTemp = Files.createTempFile("inscripciones", ".txt");
        ArchivoInscripcionLogger logger = new ArchivoInscripcionLogger(archTemp.toString());

        LocalDate apertura = LocalDate.now();
        LocalDate cierre = apertura.plusDays(5);
        Inscripcion inscripcion = new Inscripcion(apertura, cierre, "Concurso2026", logger);
        Participante p1 = new Participante("Alejandro", "24500676");

        inscripcion.inscribirParticipante(p1, apertura);

        String contenido = Files.readString(archTemp);
        assertTrue(contenido.contains("24500676"));
        assertTrue(contenido.contains("Concurso2026"));
    }
}
