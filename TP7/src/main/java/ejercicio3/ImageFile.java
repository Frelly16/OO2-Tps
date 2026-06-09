package ejercicio3;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class ImageFile implements Imagen {
    private final BufferedImage imagen;

    public ImageFile(String path) {
        this.imagen = load(path);
        System.out.println("LOG: Imagen cargada desde el disco (" + path + ")");
    }

    @Override
    public void display() {
        ImageIcon icon = new ImageIcon(imagen);
        JLabel label = new JLabel(icon);
        JOptionPane.showMessageDialog(null, label);
    }
    private BufferedImage load(String path) {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path)){
            if (inputStream == null){
                throw new IOException("No se encontró el archivo en los recursos del proyecto: " + path);
            }
            return ImageIO.read(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Error al cargar la imagen en la ruta: " + path, e);
        }
    }


}
