package ejercicio3;

public class CachedImageProxy implements Imagen {
    private final String path;
    private ImageFile imagenReal;

    public CachedImageProxy(String path) {
        this.path = path;
    }

    @Override
    public void display() {
        if (this.imagenReal == null) {
            this.imagenReal = new ImageFile(this.path);
        } else {
            System.out.println("LOG: Retornando imagen desde la memoria cache (" + path + ")");
        }
        this.imagenReal.display();
    }
}
