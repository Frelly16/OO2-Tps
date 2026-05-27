package ejercicio5;

import ejercicio5.logger.InscripcionLogger;

import java.time.LocalDateTime;

public class FakeLogger implements InscripcionLogger {
    public boolean logFueLlamado = false;

    @Override
    public void registrar(LocalDateTime fechaHora, String idParticipante, String idConcurso) {
        this.logFueLlamado = true;
    }
}