package ejercicio1;

public class PrecioRegular extends Precio {
    @Override
    public double calcularMonto(int diasAlquilados) {
        double monto = 2;
        if (diasAlquilados > 2) {
            monto += (diasAlquilados - 2) * 1.5;
        }
        return monto;
    }
}