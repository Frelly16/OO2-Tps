package restauranteTest.punto3;

import punto2.restaurante.RestauranteLogger;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FakeRestauranteLogger implements RestauranteLogger {
    ArrayList<String> registros = new ArrayList<>();

    @Override
    public void registrar(LocalDateTime fechaHora, double montoTotal) {
        registros.add(String.format("%s || %s", fechaHora.toLocalDate(), String.valueOf(montoTotal)));
    }

    public List<String> getRegistros() {
        return registros;
    }
}
