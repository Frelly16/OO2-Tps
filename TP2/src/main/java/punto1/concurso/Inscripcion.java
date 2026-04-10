package punto1.concurso;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Inscripcion {
    public static final int PUNTOS = 10;
    private final ArrayList<Participante> inscriptos;
    private final LocalDate fechaApertura;
    private final LocalDate fechaCierre;
    private final String idConcurso;
    private final InscripcionLogger logger;


    public Inscripcion(LocalDate apertura, LocalDate cierre, String idConcurso, InscripcionLogger logger) {
        this.inscriptos = new ArrayList<>();
        this.fechaApertura = apertura;
        this.fechaCierre = cierre;
        this.idConcurso = idConcurso;
        this.logger = logger;
    }

    public void inscribirParticipante(Participante unParticipante, LocalDate fechaActual){
        if(estaDentroDeRango(fechaActual)){
            registroSumaPuntosA(unParticipante);
            inscriptos.add(unParticipante);
            logger.registrar(LocalDateTime.now(), unParticipante.getDni(), idConcurso);
        }
        else throw new IllegalArgumentException("Inscripción fuera de las fechas permitidas");
    }

    private void registroSumaPuntosA(Participante unParticipante) {
        if(LocalDate.now().equals(fechaApertura)){
            unParticipante.sumarPuntos(PUNTOS);
        }
    }

    private boolean estaDentroDeRango(LocalDate fechaActual){
        return fechaActual.isBefore(fechaCierre.plusDays(1)) && fechaActual.isAfter(fechaApertura.minusDays(1));
    }

}
