package punto3.restaurante.logger;

import java.time.LocalDateTime;

public interface RestauranteLogger {
    void registrar(LocalDateTime fechaHora, double montoTotal);
}
