package DoubleDispatch.ejercicio4;

import java.util.ArrayList;
import java.util.List;

public class CarritoCompras {
    private final Cliente cliente;
    private final List<Producto> productos;

    public CarritoCompras(Cliente cliente) {
        this.cliente = cliente;
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
    }

    public float calcularPrecio() {
        float total = 0;
        for (Producto producto : productos) {
            total += producto.precio();
            total += producto.impuesto(cliente.tipo());
            total += producto.costoEnvio(cliente.tipo());
        }
        return total;
    }
}