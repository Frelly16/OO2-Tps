package DoubleDispatch.ejercicio2;

public class MandoMedio implements Cargo {
    @Override
    public void validarSubordinado(Cargo subordinado) {
        subordinado.validarComoSubordinadoDeMandoMedio();
    }

    @Override
    public void validarComoSubordinadoDeDirector() {
    }

    @Override
    public void validarComoSubordinadoDeMandoMedio() {
        throw new RuntimeException(EmpleadoJerarquico.ASIGNACION_EMPLEADO_INVALIDA);
    }
}