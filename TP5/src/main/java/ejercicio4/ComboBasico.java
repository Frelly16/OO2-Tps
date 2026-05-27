package ejercicio4;

public class ComboBasico implements Combo {
    @Override
    public String descripcion() {
        return "Combo Básico";
    }

    @Override
    public double precio() {
        return 5000.0;
    }
}