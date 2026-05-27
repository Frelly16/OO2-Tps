package ejercicio2.composite1;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Canvas extends JPanel {
    private final List<Figura> figuras;

    public Canvas() {
        figuras = new ArrayList<>();
    }

    public void agregarFigura(Figura figura) {
        figuras.add(figura);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        Panel panel = new PanelGraphics2DAdapter(g2d);

        for (Figura figura : figuras) {
            figura.dibujar(panel);
        }
    }
}