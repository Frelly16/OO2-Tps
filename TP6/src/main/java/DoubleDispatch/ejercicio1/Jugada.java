package DoubleDispatch.ejercicio1;

public class Jugada {
    public static final String GANASTE = "¡Ganaste!";
    public static final String PERDISTE = "¡Perdiste!";
    public static final String EMPATE = "¡Es un empate!";

    public String jugar(Elemento eleccionUsuario, Elemento eleccionComputadora) {
        return eleccionUsuario.jugarContra(eleccionComputadora);
    }
}