package DoubleDispatch.ejercicio4;

public class ClienteRegular implements TipoCliente {
    @Override
    public float calcularEnvio(ServicioDigital servicio) {
        return 0f;
    }

    @Override
    public float calcularEnvio(ProductoFisico producto) {
        return producto.precio() * producto.peso();
    }

    @Override
    public float aplicarImpuesto(ServicioDigital servicio) {
        return servicio.precio() * 0.10f;
    }

    @Override
    public float aplicarImpuesto(ProductoFisico producto) {
        return producto.precio() * producto.iva();
    }
}