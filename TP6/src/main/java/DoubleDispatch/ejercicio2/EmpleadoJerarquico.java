package DoubleDispatch.ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class EmpleadoJerarquico implements Empleado {
    public static final String ASIGNACION_EMPLEADO_INVALIDA = "Asignación de empleado inválida";

    private final String nombre;
    private final List<Empleado> empleados;
    private final float salario;
    private final Cargo cargo;

    public EmpleadoJerarquico(String nombre, float salario, Cargo cargo) {
        this.nombre = nombre;
        this.salario = salario;
        this.cargo = cargo;
        this.empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        this.cargo.validarSubordinado(empleado.cargo());
        this.empleados.add(empleado);
    }

    public boolean tieneDeEmpeadoA(Empleado empleado) {
        return this.empleados.contains(empleado);
    }

    @Override
    public float calcularSalario() {
        float total = this.salario;
        for (Empleado m : empleados) {
            total += m.calcularSalario();
        }
        return total;
    }

    @Override
    public Cargo cargo() {
        return this.cargo;
    }
}