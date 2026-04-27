package ejercicio3Test;

import ejercicio3.Cena;
import ejercicio3.Desayuno;
import ejercicio3.Gasto;
import ejercicio3.ReporteDeGastos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReporteGastosTest {
    private List<Gasto> gastos;
    private ReporteDeGastos reporte;

    @BeforeEach
    public void setUp() {
        this.gastos = new ArrayList<>();
        this.reporte = new ReporteDeGastos(gastos);
    }

    @Test
    public void pruebaDesayuno() {
        //Gasto g1 = new Gasto(TipoDeGasto.DESAYUNO, 1000);
        Gasto g1 = new Desayuno(1000);
        gastos.add(g1);
        String testReporte = reporte.imprimir();

        String resultadoEsperado = "Expenses " + java.time.LocalDate.now() + "\n" +
                "Desayuno\t1000\t \n" +
                "Gastos de comida: 1000\n" +
                "Total de gastos: 1000\n";

        assertEquals(resultadoEsperado, testReporte);
    }

    @Test
    public void pruebaCenaConExceso() {
        //Gasto g1 = new Gasto(TipoDeGasto.CENA, 6000);
        Gasto g1 = new Cena(6000);
        gastos.add(g1);
        //Gasto g2 = new Gasto(TipoDeGasto.CENA, 2000);
        Gasto g2 = new Cena(2000);
        gastos.add(g2);
        String testReporte = reporte.imprimir();

        String resultadoEsperado = "Expenses " + java.time.LocalDate.now() + "\n" +
                "Cena\t6000\tX\n" +
                "Cena\t2000\t \n" +
                "Gastos de comida: 8000\n" +
                "Total de gastos: 8000\n";

        assertEquals(resultadoEsperado, testReporte);
    }


}
