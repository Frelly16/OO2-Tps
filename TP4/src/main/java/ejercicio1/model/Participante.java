package ejercicio1.model;

public class Participante {
    private final String nombre;
    private final String telefono;
    private final String region;

    public Participante(String nombre, String telefono, String region) {

        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("Debe cargar un nombre");
        }
        if (telefono == null || telefono.isEmpty()) {
            throw new IllegalArgumentException("Debe cargar un telefono");
        }
        if (!validarTelefono(telefono)) {
            throw new IllegalArgumentException("El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
        }
        if (!region.equals("China") && !region.equals("US") && !region.equals("Europa")) {
            throw new IllegalArgumentException("Region desconocida. Las conocidas son: China, US, Europa");
        }

        this.nombre = nombre;
        this.telefono = telefono;
        this.region = region;
    }

    private boolean validarTelefono(String telefono) {
        String regex = "\\d{4}-\\d{6}";
        return telefono.matches(regex);
    }

    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }
    public String getRegion() { return region; }
}