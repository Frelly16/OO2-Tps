package ejercicio3;

public abstract class Gasto {
    protected int monto;

    public Gasto(int monto) {
        this.monto = monto;
    }

    public abstract String nombreGasto();

    public int montoComida() {
        return 0;
    }

    public String marcaComidaPorExceso() {
        return " ";
    }

}
