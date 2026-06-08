package DoubleDispatch.ejercicio3;

public class HistoriaUsuario implements TipoTarea {
    @Override
    public void validarAgregado(TipoTarea subtarea) {
        subtarea.agregarseAHistoria();
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