package ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class HistoriaUsuario implements ItemTrabajo {
    private final List<ItemTrabajo> tareas = new ArrayList<>();

    public void agregar(ItemTrabajo item) {
        tareas.add(item);
    }

    @Override
    public int calcularTiempo() {
        return tareas.stream()
                .mapToInt(ItemTrabajo::calcularTiempo)
                .sum();
    }
}