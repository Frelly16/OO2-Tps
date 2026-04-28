package ejercicio3.datos;

import ejercicio3.model.Concurso;
import ejercicio3.model.Participante;
import ejercicio3.model.RepositorioInscripciones;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class RepositorioInscripcionesTXT implements RepositorioInscripciones {
    private final String rutaArchivo;

    public RepositorioInscripcionesTXT(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    @Override
    public void guardar(Participante p, Concurso c) {
        try (PrintWriter out = new PrintWriter(new FileWriter(rutaArchivo, true))) {
            String linea = String.format("%s, %s, %s, %s, %d",
                    p.getApellido(), p.getNombre(), p.getTelefono(), p.getEmail(), c.getId());
            out.println(linea);
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar la inscripción", e);
        }
    }
}