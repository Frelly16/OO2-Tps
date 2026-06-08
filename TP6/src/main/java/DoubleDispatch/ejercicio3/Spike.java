package DoubleDispatch.ejercicio3;

public class Spike implements TipoTarea {
    @Override
    public void validarAgregado(TipoTarea subtarea) {}

    @Override
    public void agregarseAHistoria() {
        throw new RuntimeException(TareaCompleja.VALIDA_HISTORIA);
    }

    @Override
    public void agregarseAEpica() {
    }

    @Override
    public void validarComoSimple() {
    }

    @Override
    public void validarComoCompleja() {
        throw new RuntimeException(TareaCompleja.VALIDA_TAREA_COMPLEJA);
    }
}