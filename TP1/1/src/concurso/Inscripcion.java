package concurso;

import java.time.LocalDate;
import java.util.ArrayList;

public class Inscripcion {
    public static final int PUNTOS = 10;
    private final ArrayList<Participante> Inscriptos;
    private final LocalDate fechaApertura;
    private final LocalDate fechaCierre;


    public Inscripcion(LocalDate apertura, LocalDate cierre) {
        this.Inscriptos = new ArrayList<>();
        this.fechaApertura = apertura;
        this.fechaCierre = cierre;
    }

    public void inscribirParticipante(Participante unParticipante, LocalDate fechaActual){
        if(estaDentroDeRango(fechaActual)){
            if(LocalDate.now().equals(fechaApertura)){
                unParticipante.sumarPuntos(PUNTOS);
            }
            Inscriptos.add(unParticipante);
        }
        else throw new IllegalArgumentException("Inscripción fuera de las fechas permitidas");
    }

    private boolean estaDentroDeRango(LocalDate fechaActual){
        return fechaActual.isBefore(fechaCierre.plusDays(1)) && fechaActual.isAfter(fechaApertura.minusDays(1));
    }

}
