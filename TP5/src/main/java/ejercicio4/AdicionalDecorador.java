package ejercicio4;

public abstract class AdicionalDecorador implements Combo {
    protected final Combo combo;

    public AdicionalDecorador(Combo combo) {
        this.combo = combo;
    }
}