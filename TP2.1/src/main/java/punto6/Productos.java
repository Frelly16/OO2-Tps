package punto6;

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

    private void ejecutarConPermiso(boolean tienePermiso, Runnable accion) {
        if (!tienePermiso) {
            throw new RuntimeException(SIN_PERMISOS);
        }
        accion.run();
    }

    private <T> T ejecutarConPermiso(boolean tienePermiso, Supplier<T> accion) {
        if (!tienePermiso) {
            throw new RuntimeException(SIN_PERMISOS);
        }
        return accion.get();
    }

    public void addProducto(String userId, Producto producto) {
        ejecutarConPermiso(this.security.checkAddPermission(userId), () -> this.productos.add(producto));
    }

    public void removeProducto(String userId, Producto producto) {
        ejecutarConPermiso(this.security.checkRemovePermission(userId), () -> this.productos.remove(producto));
    }

    public List<Producto> listAll(String userId) {
        return ejecutarConPermiso(this.security.checkListPermission(userId), () -> Collections.unmodifiableList(this.productos));
    }

    int cantidad() {
        return this.productos.size();
    }

    boolean contiene(Producto unProducto) {
        return this.productos.contains(unProducto);
    }
}