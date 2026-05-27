package ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class EmpleadoJerarquico implements Empleado {
    private final double salarioPropio;
    private final List<Empleado> subordinados;

    public EmpleadoJerarquico(double salarioPropio) {
        this.salarioPropio = salarioPropio;
        this.subordinados = new ArrayList<>();
    }

    public void asignarSubordinado(Empleado empleado) {
        this.subordinados.add(empleado);
    }

    @Override
    public double calcularSalarioTotal() {
        return salarioPropio + subordinados.stream()
                .mapToDouble(Empleado::calcularSalarioTotal)
                .sum();
    }
}