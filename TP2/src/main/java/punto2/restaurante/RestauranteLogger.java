package punto2.restaurante;

import java.time.LocalDateTime;

public interface RestauranteLogger {
    void registrar(LocalDateTime fechaHora, double montoTotal);
}
