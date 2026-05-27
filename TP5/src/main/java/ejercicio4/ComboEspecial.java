package ejercicio4;

public class ComboEspecial implements Combo {
    @Override
    public String descripcion() {
        return "Combo Especial";
    }

    @Override
    public double precio() {
        return 10000.0;
    }
}