package punto4;

import java.sql.Connection;
import java.sql.SQLException;

@FunctionalInterface
public interface OperacionDB {
    void ejecutar(Connection connection) throws SQLException;
}