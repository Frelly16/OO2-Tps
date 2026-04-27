package ejercicio3;

public class Desayuno extends Gasto {
    public Desayuno(int monto) {
        super(monto);
    }

    @Override
    public String nombreGasto() {
        return "Desayuno";
    }

    @Override
    public int montoComida() {
        return this.monto;
    }

    @Override
    public String marcaComidaPorExceso() {
        return this.monto > 1000 ? "X" : " ";
    }
}
