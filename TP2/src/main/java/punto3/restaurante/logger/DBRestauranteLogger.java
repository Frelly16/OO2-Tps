package punto3.restaurante.logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class DBRestauranteLogger implements RestauranteLogger{
    private final Connection connection;

    public DBRestauranteLogger(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void registrar(LocalDateTime fechaHora, double montoTotal) {
        String sql = "INSERT INTO consumos (fecha_hora, monto_total) " +
                "VALUES (?, ?)";
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setObject(1, fechaHora);
            st.setDouble(2, montoTotal);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al registrar el consumo en la Base de Datos", e);
        }
    }
}
