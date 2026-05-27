package ejercicio4;

public class Carne extends AdicionalDecorador {
    public Carne(Combo combo) {
        super(combo);
    }

    @Override
    public String descripcion() {
        return combo.descripcion() + " + Carne";
    }

    @Override
    public double precio() {
        return combo.precio() + 2000.0;
    }
}