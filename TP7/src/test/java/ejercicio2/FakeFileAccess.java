package ejercicio2;

public class FakeFileAccess implements Archivo {
    @Override
    public String readFile() {
        return "Contenido secreto";
    }
}