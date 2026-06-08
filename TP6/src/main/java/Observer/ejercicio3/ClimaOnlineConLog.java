package Observer.ejercicio3;

public class ClimaOnlineConLog implements ClimaOnline {
    private final ClimaOnline climaEnvuelto;

    public ClimaOnlineConLog(ClimaOnline climaEnvuelto) {
        this.climaEnvuelto = climaEnvuelto;
    }

    @Override
    public String temperatura() {
        System.out.println("[LOG INTERNO] -> Consultando temperatura al servicio externo de OpenWeatherMap...");
        return climaEnvuelto.temperatura();
    }
}