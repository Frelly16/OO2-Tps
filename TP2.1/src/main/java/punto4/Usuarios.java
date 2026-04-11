package punto4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Usuarios {

    private final String jdbcUrl;

    public Usuarios(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    private void ejecutarTransaccion(OperacionDB operacion) {
        try (Connection connection = DriverManager.getConnection(this.jdbcUrl)) {
            connection.setAutoCommit(false);

            try {
                operacion.ejecutar(connection);
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                throw new RuntimeException("Error ejecutando operación en la base de datos", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error de conexión a la base de datos", e);
        }
    }

    public void insertar(String nombre, String email) {
        ejecutarTransaccion(connection -> {
            try (PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO usuarios (nombre, email) VALUES (?, ?)")) {
                statement.setString(1, nombre);
                statement.setString(2, email);
                statement.executeUpdate();
            }
        });
    }

    public void actualizarEmail(int id, String nuevoEmail) {
        ejecutarTransaccion(connection -> {
            try (PreparedStatement statement = connection.prepareStatement(
                    "UPDATE usuarios SET email = ? WHERE id = ?")) {
                statement.setString(1, nuevoEmail);
                statement.setInt(2, id);
                statement.executeUpdate();
            }
        });
    }
}