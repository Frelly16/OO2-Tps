package ejercicio3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ReporteExportacionTest {

    @Test
    @DisplayName("Un reporte básico sobrescribe el contenido si el archivo ya existe")
    public void exportar_reporteBasico_sobrescribeArchivoExistente() throws IOException {
        File archivoTemp = Files.createTempFile("test_reporte", ".txt").toFile();
        Files.writeString(archivoTemp.toPath(), "Texto viejo");

        Reporte reporte = new ReporteBasico("Texto nuevo");

        reporte.exportar(archivoTemp);

        String contenidoFinal = Files.readString(archivoTemp.toPath());
        assertEquals("Texto nuevo", contenidoFinal);

        archivoTemp.deleteOnExit();
    }

    @Test
    @DisplayName("Un reporte no sobrescribible lanza excepción si intenta exportar sobre un archivo existente")
    public void exportar_reporteNoSobrescribible_lanzaExcepcion() throws IOException {
        File archivoTemp = Files.createTempFile("test_protegido", ".txt").toFile();
        Reporte reporte = new ReporteNoSobrescribible(new ReporteBasico("Texto seguro"));

        assertThrows(IllegalArgumentException.class, () -> {
            reporte.exportar(archivoTemp);
        });

        archivoTemp.deleteOnExit();
    }
}