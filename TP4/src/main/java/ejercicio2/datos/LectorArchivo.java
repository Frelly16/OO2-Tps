package ejercicio2.datos;

import ejercicio2.modelo.Empleado;
import ejercicio2.modelo.LectorEmpleados;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LectorArchivo implements LectorEmpleados {
    private final String archivoURL;

    public LectorArchivo(String archivoURL) {
        this.archivoURL = archivoURL;
    }

    @Override
    public List<Empleado> cargarEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        try(BufferedReader reader = new BufferedReader(new FileReader(archivoURL))) {
            String linea;
            reader.readLine();
            while((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                String apellido = datos[0].trim();
                String nombre = datos[1].trim();
                String fechaCumple = datos[2].trim();
                String email = datos[3].trim();

                LocalDate fechaNacimiento = LocalDate.parse(fechaCumple, formatter);
                Empleado unEmpleado = new Empleado(nombre, apellido, fechaNacimiento, email);

                empleados.add(unEmpleado);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return empleados;
    }
}
