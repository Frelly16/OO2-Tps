package Observer.ejercicio4.modelo;

public class Participante {
    private final String nombre;
    private final String dni;
    private final String email;

    public Participante(String nombre, String dni, String email) {
        this.nombre = nombre;
        this.dni = dni;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public String getEmail() {
        return email;
    }
}