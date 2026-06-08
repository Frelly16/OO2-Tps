package DoubleDispatch.ejercicio4;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private final List<Producto> compra;
    private final String nombre;
    private final TipoCliente tipo;

    public Cliente(String nombre, TipoCliente tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.compra = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        this.compra.add(producto);
    }

    public TipoCliente tipo() {
        return tipo;
    }

    public List<Producto> compra() {
        return List.copyOf(compra);
    }
}