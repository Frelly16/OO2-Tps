package DoubleDispatch.ejercicio2;

public class Junior implements Cargo {
    @Override
    public void validarSubordinado(Cargo subordinado) {
        throw new RuntimeException("Un Junior no puede tener subordinados");
    }

    @Override
    public void validarComoSubordinadoDeDirector() {
        throw new RuntimeException(EmpleadoJerarquico.ASIGNACION_EMPLEADO_INVALIDA);
    }

    @Override
    public void validarComoSubordinadoDeMandoMedio() {
    }
}