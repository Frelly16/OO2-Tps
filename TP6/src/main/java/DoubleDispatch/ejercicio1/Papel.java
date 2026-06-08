package DoubleDispatch.ejercicio1;

public class Papel implements Elemento {
    @Override
    public String jugarContra(Elemento adversario) {
        return adversario.resultadoContraPapel();
    }

    @Override
    public String resultadoContraPiedra() { return Jugada.GANASTE; }

    @Override
    public String resultadoContraPapel() { return Jugada.EMPATE; }

    @Override
    public String resultadoContraTijera() { return Jugada.PERDISTE; }
}
