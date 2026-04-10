package concursoTest.punto3;

import punto1.concurso.InscripcionLogger;

import java.time.LocalDateTime;
import java.util.ArrayList;

class FakeInscripcionLogger implements InscripcionLogger {
    ArrayList<String> registros = new ArrayList<>();

    @Override
    public void registrar(LocalDateTime fechaHora, String idParticipante, String idConcurso) {
        registros.add(String.format("%s, %s, %s", fechaHora.toLocalDate(), idParticipante, idConcurso));
    }
}
