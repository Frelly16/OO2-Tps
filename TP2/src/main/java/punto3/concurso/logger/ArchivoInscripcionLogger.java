package punto3.concurso.logger;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ArchivoInscripcionLogger implements InscripcionLogger {
    private final String rutaArchivo;
    private final DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public ArchivoInscripcionLogger(String rutaArchivo){
        this.rutaArchivo = rutaArchivo;
    }

    @Override
    public void registrar(LocalDateTime fechaHora, String idParticipante, String idConcurso){
        try(FileWriter writer = new FileWriter(rutaArchivo, true)){
            String linea = String.format("%s, %s, %s%n",
                    fechaHora.format(formato), idParticipante, idConcurso);
            writer.write(linea);
        } catch(IOException e){
            throw new RuntimeException("Error al escribir inscripción en archivo.", e);
        }
    }
}
