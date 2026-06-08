package ejercicio2;

import java.io.IOException;

public class FileAccessProxy implements Archivo {
    private final Archivo archivoReal;
    private final Usuario usuario;
    private final String nombreArchivo;

    public FileAccessProxy(Archivo archivoReal, Usuario usuario, String nombreArchivo) {
        this.archivoReal = archivoReal;
        this.usuario = usuario;
        this.nombreArchivo = nombreArchivo;
    }

    @Override
    public String readFile() throws IOException {
        if (!tieneAcceso()) {
            throw new SecurityException("Acceso denegado: El usuario no posee los permisos necesarios para leer este archivo.");
        }
        return archivoReal.readFile();
    }

    private boolean tieneAcceso() {
        if (nombreArchivo.startsWith("i")) {
            return usuario.poseePermiso(Permiso.ADMIN);
        }
        if (nombreArchivo.startsWith("m")) {
            return usuario.poseePermiso(Permiso.ADMIN) || usuario.poseePermiso(Permiso.INTERMEDIO);
        }
        return true;
    }
}