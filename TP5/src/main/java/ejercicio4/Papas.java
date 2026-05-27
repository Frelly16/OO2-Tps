package ejercicio4;

public class Papas extends AdicionalDecorador {
    public Papas(Combo combo) {
        super(combo);
    }

    @Override
    public String descripcion() {
        return combo.descripcion() + " Queso";
    }

    @Override
    public double precio() {
        return combo.precio() + 1000.0;
    }
}
