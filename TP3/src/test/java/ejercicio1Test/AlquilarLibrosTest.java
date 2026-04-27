package ejercicio1Test;

import ejercicio1.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlquilarLibrosTest {
    private Cliente unCliente;
    private CopiaLibro copiaRegular;
    private CopiaLibro copiaInfantil;
    private CopiaLibro copiaNuevo;

    @BeforeEach
    public void setUp() {
        unCliente = new Cliente("Test");
        copiaRegular = new CopiaLibro(new Libro("LibroRegular", Libros.REGULARES));
        copiaInfantil = new CopiaLibro(new Libro("LibroInfantil", Libros.INFANTILES));
        copiaNuevo = new CopiaLibro(new Libro("LibroNuevo", Libros.NUEVO_LANZAMIENTO));
    }

    @Test
    public void alquilerRegularSinRecargo() {
        Alquiler alquilerRegular = new Alquiler(copiaRegular, 2);
        unCliente.alquilar(alquilerRegular);
        Object[] resultado = unCliente.calcularDeudaYPuntosObtenidos();

        assertEquals(2.0, (Double) resultado[0]);
        assertEquals(1, (Integer) resultado[1]);
    }

    @Test
    public void alquilerRegularConRecargo() {
        Alquiler alquilerRegular = new Alquiler(copiaRegular, 10);
        unCliente.alquilar(alquilerRegular);
        Object[] resultado = unCliente.calcularDeudaYPuntosObtenidos();

        assertEquals(14.0, (Double) resultado[0]);
        assertEquals(1, (Integer) resultado[1]);
    }

    @Test
    public void alquilerInfantilSinRecargo() {
        Alquiler alquilerInfantil = new Alquiler(copiaInfantil, 2);
        unCliente.alquilar(alquilerInfantil);
        Object[] resultado = unCliente.calcularDeudaYPuntosObtenidos();

        assertEquals(1.5, (Double) resultado[0]);
        assertEquals(1, (Integer) resultado[1]);
    }

    @Test
    public void alquilerInfaltilConRecargo() {
        Alquiler alquilerInfantil = new Alquiler(copiaInfantil, 4);
        unCliente.alquilar(alquilerInfantil);
        Object[] resultado = unCliente.calcularDeudaYPuntosObtenidos();

        assertEquals(3, (Double) resultado[0]);
        assertEquals(1, (Integer) resultado[1]);
    }

    @Test
    public void alquilerNuevoLanzamiento() {
        Alquiler alquilerNuevo = new Alquiler(copiaNuevo, 1);
        unCliente.alquilar(alquilerNuevo);
        Object[] resultado = unCliente.calcularDeudaYPuntosObtenidos();

        assertEquals(3.0, (Double) resultado[0]);
        assertEquals(1, (Integer) resultado[1]);
    }

    @Test
    public void alquilerNuevoLanzamientoMasDeUnDia() {
        Alquiler alquilerNuevo = new Alquiler(copiaNuevo, 3);
        unCliente.alquilar(alquilerNuevo);
        Object[] resultado = unCliente.calcularDeudaYPuntosObtenidos();

        assertEquals(9, (Double) resultado[0]);
        assertEquals(2, (Integer) resultado[1]);
    }


}
