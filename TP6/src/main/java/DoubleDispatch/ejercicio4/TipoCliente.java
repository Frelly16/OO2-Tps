package DoubleDispatch.ejercicio4;

public interface TipoCliente {
    float calcularEnvio(ServicioDigital servicio);
    float calcularEnvio(ProductoFisico producto);

    float aplicarImpuesto(ServicioDigital servicio);
    float aplicarImpuesto(ProductoFisico producto);
}