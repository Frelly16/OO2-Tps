package punto5;

import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

public class Productos {
    public static final String SIN_PERMISOS = "No tiene los permisos necesarios";
    private List<Producto> productos;
    private SecuritySubSystem security;

    public Productos(List<Producto> productos, SecuritySubSystem security) {
        this.security = security;
        this.productos = productos;
    }

    private void ejecutarConPermiso(String userId, Runnable accion) {
        if (!this.security.checkPermission(userId)) {
            throw new RuntimeException(SIN_PERMISOS);
        }
        accion.run();
    }

    private <T> T ejecutarConPermiso(String userId, Supplier<T> accion) {
        if (!this.security.checkPermission(userId)) {
            throw new RuntimeException(SIN_PERMISOS);
        }
        return accion.get();
    }

    public void addProducto(String userId, Producto producto) {
        ejecutarConPermiso(userId, () -> this.productos.add(producto));
    }

    public void removeProducto(String userId, Producto producto) {
        ejecutarConPermiso(userId, () -> this.productos.remove(producto));
    }

    public List<Producto> listAll(String userId) {
        return ejecutarConPermiso(userId, () -> Collections.unmodifiableList(this.productos));
    }

    int cantidad() {
        return this.productos.size();
    }

    boolean contiene(Producto unProducto) {
        return this.productos.contains(unProducto);
    }
}