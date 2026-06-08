package Observer.ejercicio3;

public class MainClima {
    public static void main(String[] args) {
        ClimaOnline apiReal = new WeatherChannelService("TU_API_KEY", "Viedma, Argentina");

        //Patrón Decorator
        ClimaOnline apiConLog = new ClimaOnlineConLog(apiReal);

        //Patrón Observer
        Medidor medidor = new Medidor(apiConLog);
        medidor.agregarObservador(new ControladorClimatizacion());
        medidor.agregarObservador(new RegistroClimaArchivo("clima_log.txt"));

        medidor.leerTemperatura();
    }
}