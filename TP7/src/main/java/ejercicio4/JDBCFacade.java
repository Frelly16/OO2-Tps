package ejercicio4;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCFacade implements DBFacade {
    private final String url;
    private final String user;
    private final String password;
    private Connection connection;

    public JDBCFacade(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void open() {
        try {
            this.connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException("Error al abrir la conexión a la base de datos.", e);
        }
    }

    @Override
    public List<Map<String, String>> queryResultAsAsociation(String sql) {
        verificarConexion();
        List<Map<String, String>> resultados = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (resultSet.next()) {
                Map<String, String> fila = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    fila.put(metaData.getColumnName(i).toLowerCase(), resultSet.getString(i));
                }
                resultados.add(fila);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error al ejecutar queryResultAsAsociation: " + sql, e);
        }

        return resultados;
    }

    @Override
    public List<String[]> queryResultAsArray(String sql) {
        verificarConexion();
        List<String[]> resultados = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (resultSet.next()) {
                String[] fila = new String[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    fila[i] = resultSet.getString(i + 1);
                }
                resultados.add(fila);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error al ejecutar queryResultAsArray: " + sql, e);
        }

        return resultados;
    }

    @Override
    public void execute(String sql) {
        verificarConexion();
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException("Error al ejecutar la sentencia: " + sql, e);
        }
    }

    @Override
    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al cerrar la conexión.", e);
        }
    }

    private void verificarConexion() {
        try {
            if (connection == null || connection.isClosed()) {
                throw new RuntimeException("La conexión a la base de datos no está abierta.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al verificar estado de la conexión.", e);
        }
    }
}