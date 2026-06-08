package DoubleDispatch.ejercicio5;

public class Deteriorado implements Condicion {
    @Override
    public int diasPara(Libro libro) {
        return libro.calcularDiasBase(); // Los libros no sufren penalidad de tiempo por deterioro según las reglas
    }

    @Override
    public int diasPara(Disco disco) {
        if (disco.anioBanda() < 1980) {
            throw new RuntimeException("No se puede prestar un disco deteriorado de una banda anterior a 1980");
        }
        return Math.max(1, disco.calcularDiasBase() - 1);
    }

    @Override
    public int diasPara(Revista revista) {
        int reduccion = revista.tieneMasDe10Anios() ? 3 : 1;
        return Math.max(1, revista.calcularDiasBase() - reduccion);
    }
}