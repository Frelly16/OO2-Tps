package Strategy.ejercicio2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FormatoLarga implements FormatoFecha {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("d 'de' MMMM 'de' yyyy", new Locale("es", "ES"));

    @Override
    public String formatear(LocalDate fecha) {
        String fechaFormateada = fecha.format(FORMATTER);

        String[] partes = fechaFormateada.split(" ");
        partes[2] = partes[2].substring(0, 1).toUpperCase() + partes[2].substring(1);

        return String.join(" ", partes);
    }
}