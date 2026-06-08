package DoubleDispatch.ejercicio5;

import java.time.LocalDate;

public class Prestamo {
    private final Persona persona;
    private final Articulo articulo;
    private final Condicion condicion;
    private final LocalDate fechaInicio;
    private final LocalDate fechaDevolucion;

    public Prestamo(Persona persona, Articulo articulo, Condicion condicion, LocalDate fechaInicio) {
        this.persona = persona;
        this.articulo = articulo;
        this.condicion = condicion;
        this.fechaInicio = fechaInicio;

        // Aquí ocurre la magia del Double Dispatch
        int diasDePrestamo = articulo.calcularDiasDePrestamo(condicion);
        this.fechaDevolucion = fechaInicio.plusDays(diasDePrestamo);
    }

    public LocalDate fechaDevolucion() {
        return fechaDevolucion;
    }
}