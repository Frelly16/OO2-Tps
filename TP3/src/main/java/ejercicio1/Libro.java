package ejercicio1;

public class Libro {
    private String nombre;
    private Libros tipoLibro;
    private Precio precio;

    public Libro(String nombre, Libros tipoLibro) {
        this.nombre = nombre;
        this.tipoLibro = tipoLibro;
        precioLibro(tipoLibro);
    }

    public Libros tipoLibro() {
        return tipoLibro;
    }

    public String nombre() {
        return nombre;
    }

    public double monto(int diasAlquilados) {
        return precio.calcularMonto(diasAlquilados);
    }

    private void precioLibro(Libros tipoLibro) {
        switch (tipoLibro) {
            case REGULARES -> {
                this.precio = new PrecioRegular();
                break;
            }
            case INFANTILES -> {
                this.precio = new PrecioInfantil();
                break;
            }
            case NUEVO_LANZAMIENTO -> {
                this.precio = new PrecioNuevoLanzamiento();
                break;
            }
        }
    }
}