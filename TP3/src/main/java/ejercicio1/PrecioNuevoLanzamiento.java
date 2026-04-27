package ejercicio1;

public class PrecioNuevoLanzamiento extends Precio {

    @Override
    public double calcularMonto(int diasAlquilados) {
        return diasAlquilados * 3;
    }

    @Override
    public int puntosAlquilerFrecuente(int diasAlquilados) {
        return (diasAlquilados > 1) ? 2 : 1;
    }
}
