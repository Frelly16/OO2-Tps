package ejercicio2.modelo;

import java.time.LocalDate;

public class Empleado {
    private final String nombre;
    private final String apellido;
    private final LocalDate cumple;
    private final String email;

    public Empleado(String nombre, String apellido, LocalDate cumple, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cumple = cumple;
        this.email = email;
    }
    public String nombre() { return this.nombre;}
    public String apellido() { return this.apellido;}
    public LocalDate fechaNacimiento() { return this.cumple;}
    public String email() { return this.email;}
}
