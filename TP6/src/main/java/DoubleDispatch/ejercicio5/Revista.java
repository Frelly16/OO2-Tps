package DoubleDispatch.ejercicio5;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Revista implements Articulo {
    private final int paginas;
    private final LocalDate fechaPublicacion;

    public Revista(int paginas, LocalDate fechaPublicacion) {
        this.paginas = paginas;
        this.fechaPublicacion = fechaPublicacion;
    }

    @Override
    public int calcularDiasDePrestamo(Condicion condicion) {
        return condicion.diasPara(this);
    }

    public int calcularDiasBase() {
        if (paginas < 100) return 2;
        if (paginas <= 2000) return 3;
        return 5;
    }

    public boolean tieneMasDe10Anios() {
        return ChronoUnit.YEARS.between(fechaPublicacion, LocalDate.now()) > 10;
    }
}