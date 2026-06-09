package ejercicio4;

import java.util.List;
import java.util.Map;

public class MainFacadeTest {

    public static void main(String[] args) {
        DBFacade db = new JDBCFacade("jdbc:derby:memory:tp7db;create=true", "app", "app");

        System.out.println("1. Abriendo conexión...");
        db.open();

        System.out.println("2. Creando el modelo relacional del Ejercicio 1...");
        db.execute("CREATE TABLE personas (id INT PRIMARY KEY, nombre VARCHAR(100))");
        db.execute("CREATE TABLE telefonos (id INT PRIMARY KEY, numero VARCHAR(20), idPersona INT)");

        System.out.println("3. Insertando datos de prueba...");
        db.execute("INSERT INTO personas VALUES (1, 'Federico Ciccarelli')");
        db.execute("INSERT INTO telefonos VALUES (101, '2920-123456', 1)");
        db.execute("INSERT INTO telefonos VALUES (102, '2920-654321', 1)");

        System.out.println("4. Probando queryResultAsAsociation (Retorna Mapas)...");
        String sqlAsociacion = "SELECT p.nombre, t.numero FROM personas p JOIN telefonos t ON p.id = t.idPersona";
        List<Map<String, String>> resultadoMapas = db.queryResultAsAsociation(sqlAsociacion);

        for (Map<String, String> fila : resultadoMapas) {
            System.out.println(" - Mapa Fila -> Nombre: " + fila.get("nombre") + " | Teléfono: " + fila.get("numero"));
        }

        System.out.println("5. Probando queryResultAsArray (Retorna Arreglos)...");
        String sqlArray = "SELECT nombre FROM personas WHERE id = 1";
        List<String[]> resultadoArreglos = db.queryResultAsArray(sqlArray);

        for (String[] fila : resultadoArreglos) {
            System.out.println(" - Array Fila -> [0]: " + fila[0]);
        }

        System.out.println("6. Cerrando conexión...");
        db.close();
        System.out.println("Prueba finalizada con éxito.");
    }
}