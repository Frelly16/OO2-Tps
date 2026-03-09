package FormaAnemica;

import java.time.LocalDate;

public class Tiempo {
    private LocalDate fechaActual;

    public Tiempo(){
        this.fechaActual = LocalDate.now();
    }
    public LocalDate getFechaActual(){
        return this.fechaActual;
    }
    public void setFechaActual(LocalDate fechaActual){
        this.fechaActual = fechaActual;
    }
}