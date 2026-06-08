package DoubleDispatch.ejercicio5;

public class Nuevo implements Condicion {
    @Override
    public int diasPara(Libro libro) {
        return libro.calcularDiasBase();
    }

    @Override
    public int diasPara(Disco disco) {
        return disco.calcularDiasBase();
    }

    @Override
    public int diasPara(Revista revista) {
        return revista.calcularDiasBase();
    }
}