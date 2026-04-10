package concursoTest.punto4;

import punto4.concurso.logger.InscripcionLogger;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FakeArchivoInscripcionLogger implements InscripcionLogger {
    private final List<String> registros = new ArrayList<>();

    @Override
    public void registrar(LocalDateTime fechaHora, String idParticipante, String idConcurso) {
        registros.add(fechaHora + " - " + idParticipante + " - " + idConcurso);
    }

    public List<String> getRegistros() {
        return registros;
    }
}
