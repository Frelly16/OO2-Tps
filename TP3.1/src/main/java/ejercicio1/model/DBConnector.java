package ejercicio1.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnector implements RegistroParticipantes{
    private Connection dbConn;
    private final static String URL = "jdbc:derby://localhost:1527/participantes";
    private final static String USER = "app";
    private final static String PASSWORD = "app";

    public DBConnector() throws SQLException {
        this.dbConn = DriverManager.getConnection(URL, USER, PASSWORD);
    }

    @Override
    public void guardarParticipante(Participante participante) throws SQLException{
        try (PreparedStatement st = dbConn.prepareStatement
                ("insert into participantes(nombre, telefono, region) values(?,?,?)")) {
            st.setString(1, participante.getNombre());
            st.setString(2, participante.getTelefono());
            st.setString(3, participante.getRegion());
            st.executeUpdate();
        }
    }
}
