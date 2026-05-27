package ejercicio5.main;

import ejercicio5.logger.ArchivoInscripcionLogger;
import ejercicio5.modelo.Concurso;
import ejercicio5.modelo.Inscripcion;
import ejercicio5.modelo.NotificadorEmailDecorador;
import ejercicio5.modelo.Participante;
import ejercicio5.service.EmailService;

import java.time.LocalDate;

public class Main {

    private static final String MAILTRAP_USERNAME = "425a926065d951";
    private static final String MAILTRAP_PASSWORD = "0c4b20791054dd";
    private static final String MAILTRAP_HOST = "sandbox.smtp.mailtrap.io";
    private static final int MAILTRAP_PORT = 587;

    public static void main(String[] args) throws InterruptedException {

        EmailService emailService = new EmailService(MAILTRAP_USERNAME, MAILTRAP_PASSWORD, MAILTRAP_HOST, MAILTRAP_PORT);
        ArchivoInscripcionLogger logger = new ArchivoInscripcionLogger("Inscripciones.txt");
        String idConcurso = "Concurso2026";

        Inscripcion inscripcionBase = new Inscripcion(LocalDate.now(), LocalDate.now().plusDays(5), idConcurso, logger);

        Concurso concurso = new NotificadorEmailDecorador(inscripcionBase, emailService, idConcurso);

        Participante p1 = new Participante("Juan", "29011821", "JuanRoquez@gmail.com");
        concurso.inscribirParticipante(p1, LocalDate.now());

        Participante p2 = new Participante("Laura", "40621999", "LauraGomez123@yahoo.com");
        concurso.inscribirParticipante(p2, LocalDate.now());
    }
}