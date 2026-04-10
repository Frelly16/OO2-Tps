package punto3.concurso.logger;

import java.time.LocalDateTime;

public interface InscripcionLogger {
    void registrar(LocalDateTime fechaHora, String idParticipante, String idConcurso);
}
