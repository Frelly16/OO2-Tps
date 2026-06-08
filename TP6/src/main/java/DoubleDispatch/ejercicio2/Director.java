package DoubleDispatch.ejercicio2;

public class Director implements Cargo {
    @Override
    public void validarSubordinado(Cargo subordinado) {
        subordinado.validarComoSubordinadoDeDirector();
    }

    @Override
    public void validarComoSubordinadoDeDirector() {
        throw new RuntimeException(EmpleadoJerarquico.ASIGNACION_EMPLEADO_INVALIDA);
    }

    @Override
    public void validarComoSubordinadoDeMandoMedio() {
        throw new RuntimeException(EmpleadoJerarquico.ASIGNACION_EMPLEADO_INVALIDA);
    }
}