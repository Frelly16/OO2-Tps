package ejercicio1;

public class PrecioInfantil extends Precio {
    @Override
    public double calcularMonto(int diasAlquilados) {
        double monto = 1.5;
        if (diasAlquilados > 3) {
            monto += (diasAlquilados - 3) * 1.5;
        }
        return monto;
    }
}
