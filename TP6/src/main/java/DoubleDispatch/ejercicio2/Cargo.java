package DoubleDispatch.ejercicio2;

public interface Cargo {
    void validarSubordinado(Cargo subordinado);
    void validarComoSubordinadoDeDirector();
    void validarComoSubordinadoDeMandoMedio();
}