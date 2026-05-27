package ejercicio2.composite1;

public class Linea implements Figura {
    private final Coordenada coordenada;
    private final int longitud;

    public Linea(Coordenada coordenada, int longitud) {
        this.longitud = longitud;
        this.coordenada = coordenada;
    }

    @Override
    public void dibujar(Panel panel) {
        panel.pintarLinea(coordenada.x(), coordenada.y(), coordenada.x() + longitud, coordenada.y());
    }
}