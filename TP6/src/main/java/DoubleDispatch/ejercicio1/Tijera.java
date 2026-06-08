package DoubleDispatch.ejercicio1;

public class Tijera implements Elemento {
    @Override
    public String jugarContra(Elemento adversario) {
        return adversario.resultadoContraTijera();
    }

    @Override
    public String resultadoContraPiedra() { return Jugada.PERDISTE; }

    @Override
    public String resultadoContraPapel() { return Jugada.GANASTE; }

    @Override
    public String resultadoContraTijera() { return Jugada.EMPATE; }
}