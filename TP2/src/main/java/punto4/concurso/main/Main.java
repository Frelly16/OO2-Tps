package punto4.concurso.main;
import punto4.concurso.logger.ArchivoInscripcionLogger;
import punto4.concurso.modelo.Inscripcion;
import punto4.concurso.modelo.Participante;
import punto4.concurso.service.EmailService;

import java.time.LocalDate;


public class Main {

    private static final String MAILTRAP_USERNAME = "425a926065d951";
    private static final String MAILTRAP_PASSWORD = "0c4b20791054dd";
    private static final String MAILTRAP_HOST = "sandbox.smtp.mailtrap.io";
    private static final int MAILTRAP_PORT = 587;

    public static void main(String[] args) throws InterruptedException {

        EmailService emailService = new EmailService(MAILTRAP_USERNAME, MAILTRAP_PASSWORD, MAILTRAP_HOST, MAILTRAP_PORT);
        ArchivoInscripcionLogger logger = new ArchivoInscripcionLogger("Inscripciones.txt");

        Inscripcion inscripcion = new Inscripcion(LocalDate.now(), LocalDate.now().plusDays(5), "Concurso2026", logger, emailService);
        Participante p1 = new Participante("Juan", "29011821", "JuanRoquez@gmail.com" );
        inscripcion.inscribirParticipante(p1, LocalDate.now());

        Participante p2 = new Participante("Laura", "40621999", "LauraGomez123@yahoo.com");

        inscripcion.inscribirParticipante(p2, LocalDate.now());
    }
}
