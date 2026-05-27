package ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class PaqueteSeguros implements Seguro {
    private static final double DESCUENTO_POR_SEGURO = 0.05;
    private final List<Seguro> seguros = new ArrayList<>();

    public void agregar(Seguro seguro) {
        seguros.add(seguro);
    }

    @Override
    public double calcularCosto() {
        double subtotal = seguros.stream()
                .mapToDouble(Seguro::calcularCosto)
                .sum();

        double porcentajeDescuento = contarSeguros() * DESCUENTO_POR_SEGURO;

        return subtotal * (1.0 - porcentajeDescuento);
    }

    @Override
    public int contarSeguros() {
        return seguros.stream()
                .mapToInt(Seguro::contarSeguros)
                .sum();
    }
}