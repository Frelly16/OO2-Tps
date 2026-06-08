package Observer.ejercicio3;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WeatherChannelService implements ClimaOnline {
    private final String apiKey;
    private final String ciudad;

    public WeatherChannelService(String apiKey, String ciudad) {
        this.apiKey = apiKey;
        this.ciudad = ciudad;
    }

    @Override
    public String temperatura() {
        String url = String.format("https://api.openweathermap.org/data/2.5/weather?q=%s&units=metric&APPID=%s", ciudad, apiKey);

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return extraerTemperaturaDelJson(response.body()) + " c";
        } catch (Exception e) {
            throw new RuntimeException("Error al consultar el servicio de clima", e);
        }
    }

    private String extraerTemperaturaDelJson(String json) {
        String clave = "\"temp\":";
        int inicio = json.indexOf(clave) + clave.length();
        int fin = json.indexOf(",", inicio);
        return json.substring(inicio, fin);
    }
}