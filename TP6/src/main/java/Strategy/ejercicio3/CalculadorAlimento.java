package Strategy.ejercicio3;

public class CalculadorAlimento implements CalculadorDePrecios {
    @Override
    public double calcularPrecioFinal(double precioBase) {
        double impuestos = 0.05;
        double descuentos = precioBase > 100 ? 0.15 : 0.0;
        boolean envioGratis = precioBase > 200;

        double total = precioBase * (1 + impuestos) * (1 - descuentos);
        return envioGratis ? total - 10 : total;
    }
}