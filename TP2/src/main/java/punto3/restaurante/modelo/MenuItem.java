package punto3.restaurante.modelo;

public class MenuItem {
    private final String nombre;
    private final double precio;
    private final TipoItem tipo;

    public MenuItem(String nombre, double precio, TipoItem item){
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = item;
    }

    public double getPrecio(){
        return this.precio;
    }

    public TipoItem getTipo(){
        return this.tipo;
    }
}
