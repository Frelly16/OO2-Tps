package ejercicio4;

public class Tomate extends AdicionalDecorador {
    public Tomate(Combo combo) {
        super(combo);
    }

    @Override
    public String descripcion() {
        return combo.descripcion() + " + Tomate";
    }

    @Override
    public double precio() {
        return combo.precio() + 500.0;
    }
}