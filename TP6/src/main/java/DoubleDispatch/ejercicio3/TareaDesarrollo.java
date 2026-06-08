package DoubleDispatch.ejercicio3;

public class TareaDesarrollo implements TipoTarea {
    @Override
    public void validarAgregado(TipoTarea subtarea) {}

    @Override
    public void agregarseAHistoria() {
    }

    @Override
    public void agregarseAEpica() {
        throw new RuntimeException(TareaCompleja.VALIDA_EPICA);
    }

    @Override
    public void validarComoSimple() {
    }

    @Override
    public void validarComoCompleja() {
        throw new RuntimeException(TareaCompleja.VALIDA_TAREA_COMPLEJA);
    }
}