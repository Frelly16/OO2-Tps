package DoubleDispatch.ejercicio3;

public interface TipoTarea {
    void validarAgregado(TipoTarea subtarea);

    void agregarseAHistoria();
    void agregarseAEpica();

    void validarComoSimple();
    void validarComoCompleja();
}