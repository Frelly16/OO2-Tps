package ejercicio1.model;

import java.sql.SQLException;

public interface RegistroParticipantes {
    void guardarParticipante(Participante participante) throws SQLException;
}