package DoubleDispatch.ejercicio5;

public class Disco implements Articulo {
    private final int anioBanda;

    public Disco(int anioBanda) {
        this.anioBanda = anioBanda;
    }

    @Override
    public int calcularDiasDePrestamo(Condicion condicion) {
        return condicion.diasPara(this);
    }

    public int calcularDiasBase() {
        return anioBanda < 1980 ? 3 : 5;
    }

    public int anioBanda() {
        return anioBanda;
    }
}