package ejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class PersonaDao implements TelefonoProvider {
    private static boolean baseDeDatosInicializada = false;

    private Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection("jdbc:derby:memory:ej1db;create=true", "app", "app");
    }

    private synchronized void inicializarSiEsNecesario() {
        if (baseDeDatosInicializada) {
            return;
        }

        try (Connection conn = obtenerConexion();
             Statement stmt = conn.createStatement()) {
            try {
                stmt.executeQuery("SELECT 1 FROM personas FETCH FIRST 1 ROWS ONLY");
                baseDeDatosInicializada = true;
                return;
            } catch (SQLException e) {
            }

            stmt.execute("CREATE TABLE personas (id INT PRIMARY KEY, nombre VARCHAR(100))");
            stmt.execute("CREATE TABLE telefonos (id INT PRIMARY KEY, numero VARCHAR(20), idPersona INT)");

            stmt.execute("INSERT INTO personas VALUES (1, 'Federico Ciccarelli')");
            stmt.execute("INSERT INTO telefonos VALUES (101, '2920-123456', 1)");
            stmt.execute("INSERT INTO telefonos VALUES (102, '2920-654321', 1)");

            baseDeDatosInicializada = true;
        } catch (SQLException e) {
            throw new RuntimeException("Error al inicializar la base de datos automática en memoria", e);
        }
    }

    public Persona personaPorId(int id) {
        inicializarSiEsNecesario();

        String sql = "SELECT p.nombre FROM personas p WHERE p.id = ?";

        try (Connection conn = obtenerConexion();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                String nombrePersona = result.getString(1);
                return new Persona(id, nombrePersona, new SetTelefonosProxy(id, this));
            }
            throw new RuntimeException("Persona no encontrada con el ID: " + id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Set<Telefono> obtenerTelefonosDePersona(int idPersona) {
        inicializarSiEsNecesario();

        String sql = "SELECT t.numero FROM telefonos t WHERE t.idpersona = ?";
        Set<Telefono> telefonos = new HashSet<>();

        try (Connection conn = obtenerConexion();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setInt(1, idPersona);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                telefonos.add(new Telefono(result.getString(1)));
            }
            return telefonos;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}