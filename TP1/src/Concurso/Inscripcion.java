package Concurso;

import java.time.LocalDate;
import java.util.ArrayList;

public class Inscripcion {
    private ArrayList<Participante> Inscriptos;
    private LocalDate fechaApertura;
    private LocalDate fechaCierre;

    public Inscripcion(LocalDate apertura, LocalDate cierre) {
        this.Inscriptos = new ArrayList<Participante>();
        this.fechaApertura = apertura;
        this.fechaCierre = cierre;
    }

    public void InscribirParticipante(Participante unParticipante){
        if(EstaDentroDeRango()){
            if(LocalDate.now().equals(fechaApertura)){
                //unParticipante.
            }
            Inscriptos.add(unParticipante);
        }
        else {
            throw new IllegalArgumentException("Inscripción fuera de las fechas permitidas");
        }
    }

    private boolean EstaDentroDeRango(){
        if(LocalDate.now().isBefore(fechaCierre.plusDays(1)) && LocalDate.now().isAfter(fechaApertura.minusDays(1))) {
            return true;
        }
        else return false;
    }

}
