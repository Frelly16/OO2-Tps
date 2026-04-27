package ejercicio3;

public class AlquilerAuto extends Gasto {
    public AlquilerAuto(int monto) {
        super(monto);
    }

    @Override
    public String nombreGasto() {
        return "Alquiler de Autos";
    }
}
