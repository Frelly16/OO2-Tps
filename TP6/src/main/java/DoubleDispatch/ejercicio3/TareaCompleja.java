package DoubleDispatch.ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class TareaCompleja implements ItemDeProyecto {
    public static final String VALIDA_HISTORIA = "Solo tareas de desarrollo se permiten en una historia de usuario";
    public static final String VALIDA_EPICA = "Solo spikes se permiten en una epica";
    public static final String VALIDA_TAREA_COMPLEJA = "No puede crear TS o Spike como Tarea Compleja";

    private final List<ItemDeProyecto> items;
    private final int horasEstimadas;
    private final TipoTarea tipoTarea;

    public TareaCompleja(int horasEstimadas, TipoTarea tipoTarea) {
        tipoTarea.validarComoCompleja();
        this.horasEstimadas = horasEstimadas;
        this.tipoTarea = tipoTarea;
        this.items = new ArrayList<>();
    }

    public void agregarItem(ItemDeProyecto item) {
        this.tipoTarea.validarAgregado(item.tipoTarea());
        this.items.add(item);
    }

    @Override
    public int horasTotales() {
        int horasTotales = this.horasEstimadas;
        for (ItemDeProyecto item : items) {
            horasTotales += item.horasTotales();
        }
        return horasTotales;
    }

    @Override
    public TipoTarea tipoTarea() {
        return this.tipoTarea;
    }
}