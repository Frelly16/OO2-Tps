
import ejercicio2.datos.LectorArchivo;
import ejercicio2.modelo.Empleado;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LectorArchivoTest {

    @Test
    public void testCargarEmpleados_LeeYParseaCorrectamente() throws Exception {
        // 1. Preparación: Creamos un archivo temporal en la memoria de la compu
        Path archivoTemp = Files.createTempFile("empleados_test", ".txt");

        // Escribimos el encabezado y un empleado de prueba
        String contenido = "apellido, nombre, fecha de nacimiento, email\n" +
                "Mendez, Javier, 1982/10/08, Javier@abc.com\n";
        Files.writeString(archivoTemp, contenido);

        // 2. Ejecución: Le pasamos la ruta de nuestro archivo temporal al lector
        LectorArchivo lector = new LectorArchivo(archivoTemp.toAbsolutePath().toString());
        List<Empleado> empleados = lector.cargarEmpleados();

        // 3. Validación
        assertEquals(1, empleados.size(), "Debería haber leído 1 empleado (ignorando el encabezado)");

        Empleado javier = empleados.get(0);
        assertEquals("Javier", javier.nombre());
        assertEquals("Mendez", javier.apellido());
        assertEquals(LocalDate.of(1982, 10, 8), javier.fechaNacimiento());
        assertEquals("Javier@abc.com", javier.email());

        // 4. Limpieza: Borramos el archivo temporal para no dejar basura
        Files.delete(archivoTemp);
    }
}