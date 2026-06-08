package DoubleDispatch.ejercicio4;

public class ProductoFisico implements Producto {
    private final float precio;
    private final float iva;
    private final String nombre;
    private final int peso;

    public ProductoFisico(String nombre, float precio, int peso) {
        this.precio = precio;
        this.nombre = nombre;
        this.peso = peso;
        this.iva = 0.21f;
    }

    @Override
    public float precio() { return precio; }

    public int peso() { return peso; }

    public float iva() { return iva; }

    @Override
    public float costoEnvio(TipoCliente tipo) {
        return tipo.calcularEnvio(this); // Double Dispatch
    }

    @Override
    public float impuesto(TipoCliente tipo) {
        return tipo.aplicarImpuesto(this); // Double Dispatch
    }
}