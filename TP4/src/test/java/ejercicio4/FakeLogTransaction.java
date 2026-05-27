package ejercicio4;

public class FakeLogTransaction implements LogTransaction {
    public boolean fueLlamado = false;

    @Override
    public void log(String className) {
        fueLlamado = true;
    }
}