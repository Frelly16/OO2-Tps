package ejercicio5.modelo;

import java.time.LocalDate;

public interface Concurso {
    void inscribirParticipante(Participante unParticipante, LocalDate fechaActual) throws InterruptedException;
}