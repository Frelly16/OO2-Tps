package DoubleDispatch.ejercicio2;

public class Main {
    public static void main(String[] args) {
        var director1 = new EmpleadoJerarquico("unDirector", 100, new Director());
        var mandoMedio = new EmpleadoJerarquico("mandoMedio", 50, new MandoMedio());

        director1.agregarEmpleado(mandoMedio);

        var empleadoRegular = new EmpleadoRegular("empleadoRegular", 100);
        mandoMedio.agregarEmpleado(empleadoRegular);

        new LaserX(director1).imprimirCostoSalarial();
    }
}