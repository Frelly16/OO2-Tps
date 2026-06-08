package DoubleDispatch.ejercicio4;

public class ClienteCorporativo implements TipoCliente {
    @Override
    public float calcularEnvio(ServicioDigital servicio) {
        return 0f;
    }

    @Override
    public float calcularEnvio(ProductoFisico producto) {
        float costo = producto.precio() * producto.peso();
        return costo - (costo * 0.5f);
    }

    @Override
    public float aplicarImpuesto(ServicioDigital servicio) {
        return 0f;
    }

    @Override
    public float aplicarImpuesto(ProductoFisico producto) {
        return producto.precio() * producto.iva();
    }
}