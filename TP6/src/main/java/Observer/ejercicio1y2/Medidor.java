package Observer.ejercicio1y2;

import java.util.ArrayList;
import java.util.List;

public class Medidor {
    private String temperatura;
    private final ClimaOnline clima;
    private final List<MedidorObserver> observadores;

    public Medidor(ClimaOnline clima) {
        this.clima = clima;
        this.observadores = new ArrayList<>();
    }

    public void agregarObservador(MedidorObserver observador) {
        this.observadores.add(observador);
    }

    public String leerTemperatura() {
        this.temperatura = this.clima.temperatura();

        for (MedidorObserver observador : observadores) {
            observador.temperaturaLeida(this.temperatura);
        }

        return this.temperatura;
    }
}