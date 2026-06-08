package Observer.ejercicio4.modelo;

import Observer.ejercicio4.service.EmailService;

public class NotificadorEmailObserver implements InscripcionObserver {
    private final EmailService emailService;

    public NotificadorEmailObserver(EmailService emailService) {
        this.emailService = emailService;
    }

    @Override
    public void participanteInscripto(Participante participante, String nombreConcurso) {
        String asunto = "Inscripción exitosa a " + nombreConcurso;
        String cuerpo = "Hola " + participante.getNombre() + ", te has inscripto correctamente.";

        emailService.mandarEmail(participante.getEmail(), asunto, cuerpo);
    }
}