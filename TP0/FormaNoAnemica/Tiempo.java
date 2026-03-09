package FormaNoAnemica;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Tiempo {
    private LocalDate fechaActual;

    public Tiempo() {
        this.fechaActual = LocalDate.now();
    }

    public void imprimirFormatoLargo() {
        DateTimeFormatter formatoLargo = DateTimeFormatter.ofPattern("EEEE d 'de' MMMM 'de' yyyy", new Locale("es", "ES"));
        System.out.println("Formato Largo: " + this.fechaActual.format(formatoLargo));
    }

    public void imprimirFormatoCorto() {
        DateTimeFormatter formatoCorto = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Formato Corto: " + this.fechaActual.format(formatoCorto));
    }
}