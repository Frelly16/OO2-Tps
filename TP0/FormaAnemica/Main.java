package FormaAnemica;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        Tiempo tiempo = new Tiempo();
        LocalDate fecha = tiempo.getFechaActual();

        DateTimeFormatter formatoLargo = DateTimeFormatter.ofPattern("EEEE d 'de' MMMM 'de' yyyy");
        DateTimeFormatter formatoCorto = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Fecha en Formato Largo: " + fecha.format(formatoLargo));
        System.out.println("Fecha en Formato Corto: " + fecha.format(formatoCorto));

    }
}