package DoubleDispatch.ejercicio3;

public class Epica implements TipoTarea {
    @Override
    public void validarAgregado(TipoTarea subtarea) {
        subtarea.agregarseAEpica();
    }

    @Override
    public void agregarseAHistoria() {
        throw new RuntimeException(TareaCompleja.VALIDA_HISTORIA);
    }

    @Override
    public void agregarseAEpica() {
        throw new RuntimeException(TareaCompleja.VALIDA_EPICA);
    }

    @Override
    public void validarComoSimple() {
        throw new RuntimeException(Tarea.VALIDA_TAREA_SIMPLE);
    }

    @Override
    public void validarComoCompleja() {
    }
}