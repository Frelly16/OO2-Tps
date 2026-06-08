package DoubleDispatch.ejercicio1;

public class Piedra implements Elemento {
    @Override
    public String jugarContra(Elemento adversario) {
        return adversario.resultadoContraPiedra();
    }

    @Override
    public String resultadoContraPiedra() { return Jugada.EMPATE; }

    @Override
    public String resultadoContraPapel() { return Jugada.PERDISTE; } // La piedra pierde contra el papel

    @Override
    public String resultadoContraTijera() { return Jugada.GANASTE; } // La piedra le gana a la tijera
}