package restaurante;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private final List<MenuItem> items = new ArrayList<>();

    public void agregarItem(MenuItem item){
        items.add(item);
    }

    public double calcularSubtotal(){
        return items.stream().mapToDouble(MenuItem ::getPrecio).sum();
    }

    public List<MenuItem> getItems(){
        return new ArrayList<>(items);
    }
}
