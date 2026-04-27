import ejercicio2.service.EmailService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class EmailServiceTest {
    private static final String USER = "425a926065d951";
    private static final String PASSWORD = "0c4b20791054dd";
    private static final String HOST = "sandbox.smtp.mailtrap.io";
    private static final int PORT = 587;

    @Test
    @Disabled("Quitar el @Disabled solo para probar la conexión a MailTrap")
    public void testEnviarSaludo_NoLanzaExcepciones() {
        // Preparación
        EmailService emailService = new EmailService(USER, PASSWORD, HOST, PORT);
        String destinatarioPrueba = "test@prueba.com";
        String mensajePrueba = "Este es un mensaje de prueba desde JUnit";

        // Ejecución y Validación
        // assertDoesNotThrow verifica que el código se ejecute sin que explote el try-catch interno
        assertDoesNotThrow(() -> {
            emailService.enviarSaludo(destinatarioPrueba, mensajePrueba);
        }, "El envío de email falló. Revisar credenciales de MailTrap o conexión a internet.");
    }
}