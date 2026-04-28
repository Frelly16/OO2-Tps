package ejercicio3.model;

public class Participante {
    private final String nombre;
    private final String apellido;
    private final String dni;
    private final String telefono;
    private final String email;

    public Participante(String nombre, String apellido, String dni, String telefono, String email) {
        if (nombre == null || nombre.trim().isEmpty()) throw new IllegalArgumentException("Nombre no puede ser vacio");
        if (apellido == null || apellido.trim().isEmpty()) throw new IllegalArgumentException("Apellido no puede ser vacio");
        if (dni == null || dni.trim().isEmpty()) throw new IllegalArgumentException("DNI no puede ser vacio");

        if (!telefono.matches("\\d{4}-\\d{6}")) {
            throw new IllegalArgumentException("El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
        }
        if (!email.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$")) {
            throw new IllegalArgumentException("El email debe ser válido");
        }

        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
    }

    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getTelefono() { return telefono; }
    public String getEmail() { return email; }
}