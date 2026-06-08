package ejercicio3;

public class ImageGalery {
    public static void main(final String[] args) {
        Imagen imagen = new CachedImageProxy("src/main/resources/image1.jpeg");

        System.out.println("Solicitando display por primera vez...");
        imagen.display();

        System.out.println("Solicitando display por segunda vez...");
        imagen.display();
    }
}