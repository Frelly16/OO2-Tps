package Strategy.ejercicio3;

public class Producto {
    private final double precio;
    private final CalculadorDePrecios calculador;

    public Producto(double precio, CalculadorDePrecios calculador) {
        this.precio = precio;
        this.calculador = calculador;
    }

    public double precioFinal() {
        return calculador.calcularPrecioFinal(this.precio);
    }
}