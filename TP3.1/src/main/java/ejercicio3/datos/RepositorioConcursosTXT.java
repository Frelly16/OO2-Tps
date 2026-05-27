package ejercicio3.datos;

import ejercicio3.model.Concurso;
import ejercicio3.model.RepositorioConcursos;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RepositorioConcursosTXT implements RepositorioConcursos {
    private final String rutaArchivo;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    public RepositorioConcursosTXT(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    @Override
    public List<Concurso> concursosAbiertos() {
        List<Concurso> abiertos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            br.readLine();
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                Concurso c = new Concurso(
                        Integer.parseInt(datos[0].trim()),
                        datos[1].trim(),
                        LocalDate.parse(datos[2].trim(), formatter),
                        LocalDate.parse(datos[3].trim(), formatter)
                );
                if (c.inscripcionAbierta()) {
                    abiertos.add(c);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al leer concursos", e);
        }
        return abiertos;
    }
}