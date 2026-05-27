package ejercicio2.composite1;

public interface Panel {
    void pintarCirculo(int x, int y, int radio);
    void pintarLinea(int x1, int y1, int x2, int y2);
    void pintarTexto(String texto, int x, int y);
}