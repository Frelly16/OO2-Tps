package DoubleDispatch.ejercicio4;

public class ServicioDigital implements Producto {
    private final float precio;
    private final String nombre;
    private final float iva;

    public ServicioDigital(String nombre, float precio, float iva) {
        this.precio = precio;
        this.nombre = nombre;
        this.iva = iva;
    }

    @Override
    public float precio() {
        return this.precio;
    }

    @Override
    public float costoEnvio(TipoCliente tipo) {
        return tipo.calcularEnvio(this); // Double Dispatch
    }

    @Override
    public float impuesto(TipoCliente tipo) {
        return tipo.aplicarImpuesto(this); // Double Dispatch
    }
}