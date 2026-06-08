package Strategy.ejercicio3;

public class CalculadorOtro implements CalculadorDePrecios {
    @Override
    public double calcularPrecioFinal(double precioBase) {
        double impuestos = 0.15;
        double descuentos = precioBase > 50 ? 0.05 : 0.0;
        boolean envioGratis = precioBase > 200;

        double total = precioBase * (1 + impuestos) * (1 - descuentos);
        return envioGratis ? total - 10 : total;
    }
}