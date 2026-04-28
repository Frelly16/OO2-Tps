package ejercicio3.model;

import java.time.LocalDate;

public class Concurso {
    private final int id;
    private final String nombre;
    private final LocalDate fechaInicio;
    private final LocalDate fechaFin;

    public Concurso(int id, String nombre, LocalDate fechaInicio, LocalDate fechaFin) {
        this.id = id;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public boolean inscripcionAbierta() {
        LocalDate hoy = LocalDate.now();
        return !hoy.isBefore(fechaInicio) && !hoy.isAfter(fechaFin);
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }

    @Override
    public String toString() {
        return nombre;
    }
}