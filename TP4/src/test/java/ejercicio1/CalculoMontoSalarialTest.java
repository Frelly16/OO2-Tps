package ejercicio1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculoMontoSalarialTest {

    @Test
    @DisplayName("Un empleado regular devuelve únicamente su salario base")
    public void calcularSalarioRegular() {
        Empleado regular = new EmpleadoRegular(1000.0);

        double total = regular.calcularSalarioTotal();

        assertEquals(1000.0, total);
    }

    @Test
    @DisplayName("Un cargo jerárquico suma su salario y el de toda su rama a cargo")
    public void calcularSalarioJerarquico() {
        EmpleadoJerarquico director = new EmpleadoJerarquico(5000.0);
        EmpleadoJerarquico gerente = new EmpleadoJerarquico(3000.0);
        EmpleadoJerarquico mandoMedio = new EmpleadoJerarquico(2000.0);
        EmpleadoJerarquico liderProyecto = new EmpleadoJerarquico(1500.0);

        Empleado regular1 = new EmpleadoRegular(1000.0);
        Empleado regular2 = new EmpleadoRegular(1000.0);

        liderProyecto.asignarSubordinado(regular1);
        liderProyecto.asignarSubordinado(regular2);

        mandoMedio.asignarSubordinado(liderProyecto);
        gerente.asignarSubordinado(mandoMedio);
        director.asignarSubordinado(gerente);

        double total = director.calcularSalarioTotal();

        assertEquals(13500.0, total);
    }
}