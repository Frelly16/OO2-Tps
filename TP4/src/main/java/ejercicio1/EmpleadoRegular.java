package ejercicio1;

public class EmpleadoRegular implements Empleado {
    private final double salario;

    public EmpleadoRegular(double salario) {
        this.salario = salario;
    }

    @Override
    public double calcularSalarioTotal() {
        return salario;
    }
}