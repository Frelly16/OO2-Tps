package Observer.ejercicio3;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegistroClimaArchivo implements MedidorObserver {
    private final String rutaArchivo;
    private final DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public RegistroClimaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    @Override
    public void temperaturaLeida(String temperatura) {
        try (FileWriter writer = new FileWriter(rutaArchivo, true)) {
            String linea = String.format("%s - Temperatura registrada: %s%n",
                    LocalDateTime.now().format(formato), temperatura);
            writer.write(linea);
        } catch (IOException e) {
            throw new RuntimeException("Error al escribir el log de temperatura.", e);
        }
    }
}