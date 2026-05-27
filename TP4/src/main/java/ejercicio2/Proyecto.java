package ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Proyecto implements ItemTrabajo {
    private final List<ItemTrabajo> items = new ArrayList<>();

    public void agregar(ItemTrabajo item) {
        items.add(item);
    }

    @Override
    public int calcularTiempo() {
        return items.stream()
                .mapToInt(ItemTrabajo::calcularTiempo)
                .sum();
    }
}