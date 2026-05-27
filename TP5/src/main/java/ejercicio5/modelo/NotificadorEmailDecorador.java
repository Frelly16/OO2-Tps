package ejercicio5.modelo;

import ejercicio5.service.EmailService;

import java.time.LocalDate;

public class NotificadorEmailDecorador implements Concurso {
    private final Concurso concursoEnvuelto;
    private final EmailService emailService;
    private final String idConcurso; // Necesario para el mensaje

    public NotificadorEmailDecorador(Concurso concursoEnvuelto, EmailService emailService, String idConcurso) {
        this.concursoEnvuelto = concursoEnvuelto;
        this.emailService = emailService;
        this.idConcurso = idConcurso;
    }

    @Override
    public void inscribirParticipante(Participante unParticipante, LocalDate fechaActual) throws InterruptedException {
        concursoEnvuelto.inscribirParticipante(unParticipante, fechaActual);
        emailService.mandarEmail(unParticipante.getEmail(),
                "Confirmación de inscripción",
                "Hola " + unParticipante.getNombre() + ", su inscripción al concurso " + idConcurso + " fue registrada.");
    }
}