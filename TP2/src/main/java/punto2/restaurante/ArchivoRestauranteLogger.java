package punto2.restaurante;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ArchivoRestauranteLogger implements RestauranteLogger{
    private final String rutaArchivo;
    private final DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public ArchivoRestauranteLogger(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    @Override
    public void registrar(LocalDateTime fechaHora, double montoTotal) {
        try(FileWriter writer = new FileWriter(rutaArchivo, true)) {
            String linea = String.format("%s || %s%n", fechaHora.format(formato), montoTotal);
            writer.write(linea);
        } catch (IOException e) {
            throw new RuntimeException("Error al escribir en el archivo", e);
        }
    }
}
