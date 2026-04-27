package ejercicio3;

public class Cena extends Gasto {
    public Cena(int monto) {
        super(monto);
    }

    @Override
    public String nombreGasto() {
        return "Cena";
    }

    @Override
    public int montoComida() {
        return this.monto;
    }

    @Override
    public String marcaComidaPorExceso() {
        return this.monto > 5000 ? "X" : " ";
    }
}
