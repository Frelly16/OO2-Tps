package ejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class PersonaDao implements TelefonoProvider {

    private Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
    }

    public Persona personaPorId(int id) {
        String sql = "SELECT p.nombre FROM personas p WHERE p.id = ?";

        try (Connection conn = obtenerConexion();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                String nombrePersona = result.getString(1);
                return new Persona(id, nombrePersona, new SetTelefonosProxy(id, this));
            }
            throw new RuntimeException("Persona no encontrada");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Set<Telefono> obtenerTelefonosDePersona(int idPersona) {
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