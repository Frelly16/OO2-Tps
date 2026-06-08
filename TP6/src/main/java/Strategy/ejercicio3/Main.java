package Strategy.ejercicio3;

public class Main {
    public static void main(String[] args) {
        Producto p1 = new Producto(30, new CalculadorLibro());
        Producto p2 = new Producto(330, new CalculadorMedicina());
        Producto p3 = new Producto(130, new CalculadorAlimento());
        Producto p4 = new Producto(130, new CalculadorOtro());

        System.out.println(p1.precioFinal());
        System.out.println(p2.precioFinal());
        System.out.println(p3.precioFinal());
        System.out.println(p4.precioFinal());
    }
}