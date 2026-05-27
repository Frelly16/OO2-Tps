package ejercicio2.main;

import ejercicio2.datos.LectorArchivo;
import ejercicio2.modelo.GestorCumpleaños;
import ejercicio2.modelo.LectorEmpleados;
import ejercicio2.modelo.Notificador;
import ejercicio2.service.EmailService;

public class Main {
    private static final String MAILTRAP_USERNAME = "425a926065d951";
    private static final String MAILTRAP_PASSWORD = "0c4b20791054dd";
    private static final String MAILTRAP_HOST = "sandbox.smtp.mailtrap.io";
    private static final int MAILTRAP_PORT = 587;

    public static void main(String[] args) {
        LectorEmpleados lector = new LectorArchivo("empleados.txt");
        Notificador email = new EmailService(MAILTRAP_USERNAME, MAILTRAP_PASSWORD, MAILTRAP_HOST, MAILTRAP_PORT);

        GestorCumpleaños servicio = new GestorCumpleaños(lector, email);

        servicio.enviarSaludo();
    }
}