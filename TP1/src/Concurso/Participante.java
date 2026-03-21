package Concurso;

public class Participante {
    private String nombre;
    private String dni;
    private int puntos;

    public Participante(String nombre, String dni){
        this.nombre = nombre;
        this.dni = dni;
        this.puntos = 0;
    }

    public int verPuntos() {
        return this.puntos;
    }
}
