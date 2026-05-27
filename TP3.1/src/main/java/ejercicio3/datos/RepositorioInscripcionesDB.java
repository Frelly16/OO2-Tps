package ejercicio3.datos;

import ejercicio3.model.Concurso;
import ejercicio3.model.Participante;
import ejercicio3.model.RepositorioInscripciones;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RepositorioInscripcionesDB implements RepositorioInscripciones {
    private final String url;
    private final String user;
    private final String pass;

    public RepositorioInscripcionesDB(String url, String user, String pass) {
        this.url = url; this.user = user; this.pass = pass;
    }

    @Override
    public void guardar(Participante p, Concurso c) {
        String sql = "INSERT INTO inscriptos(apellido, nombre, telefono, email, id_concurso) VALUES(?,?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement st = conn.prepareStatement(sql)) {

            st.setString(1, p.getApellido());
            st.setString(2, p.getNombre());
            st.setString(3, p.getTelefono());
            st.setString(4, p.getEmail());
            st.setInt(5, c.getId());
            st.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error en base de datos", e);
        }
    }
}