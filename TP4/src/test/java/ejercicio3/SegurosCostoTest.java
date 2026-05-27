package ejercicio3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SegurosCostoTest {

    @Test
    @DisplayName("Un seguro individual no aplica descuentos y devuelve su costo base")
    public void calcularCosto_seguroIndividual_devuelveCostoBase() {
        Seguro auto = new SeguroIndividual(1000.0);

        double costo = auto.calcularCosto();

        assertEquals(1000.0, costo);
    }

    @Test
    @DisplayName("Un paquete aplica un 5% de descuento por cada seguro simple que contiene")
    public void calcularCosto_paqueteConVariosSeguros_aplicaDescuentoAcumulativo() {
        PaqueteSeguros paqueteFamiliar = new PaqueteSeguros();
        Seguro auto = new SeguroIndividual(1000.0);
        Seguro hogar = new SeguroIndividual(2000.0);
        Seguro vida = new SeguroIndividual(3000.0);

        paqueteFamiliar.agregar(auto);
        paqueteFamiliar.agregar(hogar);
        paqueteFamiliar.agregar(vida);

        double costo = paqueteFamiliar.calcularCosto();

        assertEquals(5100.0, costo);
    }

    @Test
    @DisplayName("Un paquete que contiene otro paquete calcula los descuentos de forma recursiva")
    public void calcularCosto_paqueteDentroDePaquete_aplicaDescuentosRecursivos() {
        PaqueteSeguros paqueteInterno = new PaqueteSeguros();
        paqueteInterno.agregar(new SeguroIndividual(1000.0));
        paqueteInterno.agregar(new SeguroIndividual(1000.0));

        PaqueteSeguros paquetePrincipal = new PaqueteSeguros();
        paquetePrincipal.agregar(new SeguroIndividual(1000.0));
        paquetePrincipal.agregar(paqueteInterno);

        double costo = paquetePrincipal.calcularCosto();

        assertEquals(2380.0, costo);
    }
}