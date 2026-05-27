package ejercicio2.composite1;

public class Circulo implements Figura {
    private final int radio;
    private final Coordenada coordenada;

    public Circulo(Coordenada coordenada, int radio) {
        this.radio = radio;
        this.coordenada = coordenada;
    }

    @Override
    public void dibujar(Panel panel) {
        panel.pintarCirculo(coordenada.x(), coordenada.y(), radio);
    }
}