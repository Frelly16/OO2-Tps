package punto1.concurso;

import java.time.LocalDateTime;

public interface InscripcionLogger {
    void registrar(LocalDateTime fechaHora, String idParticipante, String idConcurso);
}
