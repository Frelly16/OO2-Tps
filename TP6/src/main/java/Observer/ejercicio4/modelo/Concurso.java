package Observer.ejercicio4.modelo;

import java.util.ArrayList;
import java.util.List;

public class Concurso {
    private final String nombre;
    private final List<Participante> inscriptos;
    private final List<InscripcionObserver> observadores;

    public Concurso(String nombre) {
        this.nombre = nombre;
        this.inscriptos = new ArrayList<>();
        this.observadores = new ArrayList<>();
    }

    public void agregarObservador(InscripcionObserver observador) {
        this.observadores.add(observador);
    }

    public void inscribir(Participante participante) {
        inscriptos.add(participante);
        notificarInscripcion(participante);
    }

    private void notificarInscripcion(Participante participante) {
        for (InscripcionObserver observador : observadores) {
            observador.participanteInscripto(participante, this.nombre);
        }
    }
}