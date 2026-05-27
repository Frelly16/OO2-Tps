package ejercicio4;

public class Queso extends AdicionalDecorador {
    public Queso(Combo combo) {
        super(combo);
    }

    @Override
    public String descripcion() {
        return combo.descripcion() + " + Queso";
    }

    @Override
    public double precio() {
        return combo.precio() + 800.0;
    }
}