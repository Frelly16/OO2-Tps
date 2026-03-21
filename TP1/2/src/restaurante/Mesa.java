package restaurante;

import java.util.ArrayList;
import java.util.List;

public class Mesa {
    private final int numero;
    private final int capacidad;
    private final List<Pedido> pedidos = new ArrayList<>();

    public Mesa(int numero, int capacidad){
        this.numero = numero;
        this.capacidad = capacidad;
    }

    public void agregarPedido(Pedido pedido){
        if(pedidos.size() < capacidad) {
            pedidos.add(pedido);
        } else throw new IllegalStateException("La mesa está completa");
    }

    public List<Pedido> getPedidos(){
        return new ArrayList<>(pedidos);
    }
}
