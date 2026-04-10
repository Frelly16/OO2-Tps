package punto4.concurso.modelo;

import punto4.concurso.logger.InscripcionLogger;
import punto4.concurso.service.EmailService;

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
    private final EmailService emailService;


    public Inscripcion(LocalDate apertura, LocalDate cierre, String idConcurso, InscripcionLogger logger, EmailService emailService) {
        this.inscriptos = new ArrayList<>();
        this.fechaApertura = apertura;
        this.fechaCierre = cierre;
        this.idConcurso = idConcurso;
        this.logger = logger;
        this.emailService = emailService;
    }

    public void inscribirParticipante(Participante unParticipante, LocalDate fechaActual) throws InterruptedException {
        if(!estaDentroDeRango(fechaActual)) {
            throw new IllegalArgumentException("Inscripción fuera de las fechas permitidas");
        }
        registroSumaPuntosA(unParticipante);
        inscriptos.add(unParticipante);
        logger.registrar(LocalDateTime.now(), unParticipante.getDni(), idConcurso);

        emailService.mandarEmail(unParticipante.getEmail(),
                "Confirmación de inscripción",
                "Hola " + unParticipante.getNombre() + ", su inscripción al concurso " + idConcurso + " fue registrada.");
    }

    private void registroSumaPuntosA(Participante unParticipante) {
        if(LocalDate.now().equals(fechaApertura)){
            unParticipante.sumarPuntos(PUNTOS);
        }
    }

    private boolean estaDentroDeRango(LocalDate fechaActual){
        return fechaActual.isBefore(fechaCierre.plusDays(1)) && fechaActual.isAfter(fechaApertura.minusDays(1));
    }

    public ArrayList<Participante> getInscriptos() {
        return inscriptos;
    }
}
