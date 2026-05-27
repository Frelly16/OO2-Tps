package ejercicio2.composite1;

import java.awt.Graphics2D;

public class PanelGraphics2DAdapter implements Panel {
    private final Graphics2D g2d;

    public PanelGraphics2DAdapter(Graphics2D g2d) {
        this.g2d = g2d;
    }

    @Override
    public void pintarCirculo(int x, int y, int radio) {
        g2d.drawOval(x - radio, y - radio, radio * 2, radio * 2);
    }

    @Override
    public void pintarLinea(int x1, int y1, int x2, int y2) {
        g2d.drawLine(x1, y1, x2, y2);
    }

    @Override
    public void pintarTexto(String texto, int x, int y) {
        g2d.drawString(texto, x, y);
    }
}