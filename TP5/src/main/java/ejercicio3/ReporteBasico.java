package ejercicio3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ReporteBasico implements Reporte {
    private final String contenido;

    public ReporteBasico(String contenido) {
        this.contenido = contenido;
    }

    @Override
    public void exportar(File archivo) {
        if (archivo == null) {
            throw new IllegalArgumentException("File es NULL; no puedo exportar...");
        }

        try {
            Files.writeString(archivo.toPath(), contenido);
        } catch (IOException e) {
            throw new RuntimeException("Falla en la escritura del archivo", e);
        }
    }
}