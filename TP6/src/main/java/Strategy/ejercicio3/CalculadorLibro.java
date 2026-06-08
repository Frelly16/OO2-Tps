package Strategy.ejercicio3;

public class CalculadorLibro implements CalculadorDePrecios {
    @Override
    public double calcularPrecioFinal(double precioBase) {
        double impuestos = 0.1;
        double descuentos = 0.1;
        boolean envioGratis = precioBase > 100;

        double total = precioBase * (1 + impuestos) * (1 - descuentos);
        return envioGratis ? total - 10 : total;
    }
}