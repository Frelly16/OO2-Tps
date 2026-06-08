package ejercicio3;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageFile implements Imagen {
    private final BufferedImage imagen;

    public ImageFile(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public void display() {
        ImageIcon icon = new ImageIcon(imagen);
        JLabel label = new JLabel(icon);
        JOptionPane.showMessageDialog(null, label);
    }
    private BufferedImage load(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            throw new RuntimeException("Error al cargar la imagen en la ruta: " + path, e);
        }
    }


}
