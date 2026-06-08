package Strategy.ejercicio2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormatoCorta implements FormatoFecha {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("d-MM-yyyy");

    @Override
    public String formatear(LocalDate fecha) {
        return fecha.format(FORMATTER);
    }
}