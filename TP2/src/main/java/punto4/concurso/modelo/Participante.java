package punto4.concurso.modelo;

public class Participante {
    private final String nombre;
    private final String dni;
    private final String email;
    private int puntos;


    public Participante(String nombre, String dni, String email){
        this.nombre = nombre;
        this.dni = dni;
        this.email = email;
        this.puntos = 0;
    }

    public void sumarPuntos(int puntos){
        this.puntos += puntos;
    }
    public int verPuntos() {
        return this.puntos;
    }

    public String getDni() {
        return dni;
    }

    public String getEmail() {
        return email;
    }

    public String getNombre() {
        return this.nombre;
    }
}
