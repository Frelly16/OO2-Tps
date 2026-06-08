package Strategy.ejercicio2;

import java.time.LocalDate;

public class Persona {
    private final LocalDate fechaNacimiento;
    private final FormatoFecha formatoFecha;

    public Persona(LocalDate fechaNacimiento, FormatoFecha formatoFecha) {
        this.fechaNacimiento = fechaNacimiento;
        this.formatoFecha = formatoFecha;
    }

    public String fechaNacimiento() {
        return formatoFecha.formatear(this.fechaNacimiento);
    }
}