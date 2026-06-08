package Observer.ejercicio3;

public class ControladorClimatizacion implements MedidorObserver {

    @Override
    public void temperaturaLeida(String temperaturaConFormato) {
        double tempNumerica = extraerNumero(temperaturaConFormato);

        if (tempNumerica < 12.0) {
            System.out.println("Hace frio, se encenderá la caldera");
        } else if (tempNumerica > 17.0) {
            System.out.println("Hace calor, se encenderá el aire acondicionado");
        }
    }

    private double extraerNumero(String temperaturaConFormato) {
        String valorLimpio = temperaturaConFormato.replace("c", "").trim();
        return Double.parseDouble(valorLimpio);
    }
}