package DoubleDispatch.ejercicio2;

public class LaserX {
    private final Empleado directorGeneral;

    public LaserX(Empleado directorGeneral) {
        this.directorGeneral = directorGeneral;
    }

    public float masaSalarial() {
        return directorGeneral.calcularSalario();
    }

    public void imprimirCostoSalarial() {
        System.out.println(masaSalarial());
    }
}