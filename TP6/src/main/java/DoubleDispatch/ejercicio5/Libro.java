package DoubleDispatch.ejercicio5;

public class Libro implements Articulo {
    private final int paginas;

    public Libro(int paginas) {
        this.paginas = paginas;
    }

    @Override
    public int calcularDiasDePrestamo(Condicion condicion) {
        // Double Dispatch: El libro se pasa a sí mismo a la condición
        return condicion.diasPara(this);
    }

    public int calcularDiasBase() {
        // 1 día cada 100 páginas, redondeando hacia arriba
        return (int) Math.ceil(paginas / 100.0);
    }
}