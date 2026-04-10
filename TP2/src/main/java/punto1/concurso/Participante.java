package punto1.concurso;

public class Participante {
    private final String nombre;
    private final String dni;
    private int puntos;

    public Participante(String nombre, String dni){
        this.nombre = nombre;
        this.dni = dni;
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
}
