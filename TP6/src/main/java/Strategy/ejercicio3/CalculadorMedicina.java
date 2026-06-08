package Strategy.ejercicio3;

public class CalculadorMedicina implements CalculadorDePrecios {
    @Override
    public double calcularPrecioFinal(double precioBase) {
        double impuestos = 0.0;
        double descuentos = precioBase > 50 ? 0.1 : 0.0;
        boolean envioGratis = precioBase > 100;

        double total = precioBase * (1 + impuestos) * (1 - descuentos);
        return envioGratis ? total - 10 : total;
    }
}