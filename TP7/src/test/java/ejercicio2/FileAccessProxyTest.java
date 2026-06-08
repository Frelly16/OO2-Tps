package ejercicio2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FileAccessProxyTest {

    @Test
    @DisplayName("Archivos 'i' permiten acceso solo a ADMIN")
    public void accesoArchivoImportante_adminPermitido() {
        Usuario admin = new Usuario("Admin", List.of(Permiso.ADMIN));
        Archivo proxy = new FileAccessProxy(new FakeFileAccess(), admin, "importante.txt");

        assertDoesNotThrow(proxy::readFile);
    }

    @Test
    @DisplayName("Archivos 'i' deniegan acceso a usuarios sin permisos")
    public void accesoArchivoImportante_basicoDenegado() {
        Usuario basico = new Usuario("Basico", List.of(Permiso.BASICO));
        Archivo proxy = new FileAccessProxy(new FakeFileAccess(), basico, "importante.txt");

        assertThrows(SecurityException.class, proxy::readFile);
    }

    @Test
    @DisplayName("Archivos 'm' permiten acceso a INTERMEDIO")
    public void accesoArchivoMedio_intermedioPermitido() throws IOException {
        Usuario intermedio = new Usuario("Intermedio", List.of(Permiso.INTERMEDIO));
        Archivo proxy = new FileAccessProxy(new FakeFileAccess(), intermedio, "medio.txt");

        assertEquals("Contenido secreto", proxy.readFile());
    }

    @Test
    @DisplayName("Archivos sin prefijo protegido permiten acceso a todos")
    public void accesoArchivoNormal_todosPermitidos() {
        Usuario basico = new Usuario("Basico", List.of(Permiso.BASICO));
        Archivo proxy = new FileAccessProxy(new FakeFileAccess(), basico, "general.txt");

        assertDoesNotThrow(proxy::readFile);
    }
}