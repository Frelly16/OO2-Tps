package punto3.concurso.logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class DBInscripcionLogger implements InscripcionLogger{
    private final Connection connection;

    public DBInscripcionLogger(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void registrar(LocalDateTime fechaHora, String idParticipante, String idConcurso) {
        String sql = "INSERT INTO inscripciones (fecha_hora, id_participante, id_concurso)" +
                " VALUES (?, ?, ?)";
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setObject(1, fechaHora);
            st.setObject(2, idParticipante);
            st.setObject(3, idConcurso);
            st.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error al registrar inscripcion en la Base de Datos", e);
        }
    }
}
