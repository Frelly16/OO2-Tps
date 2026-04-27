package ejercicio5;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        var factura = crearFactura();

        System.out.println(new Calculador().reporte(factura));
    }

    private static Factura crearFactura() {
        return new Factura("c1", List.of(
                new Comedia("Escuela de Rock", 158),
                //new Actuacion("Hamlet", 103),
                new Drama("El Perfume", 8)));
    }
}