package ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class EjemploDeUsoDelReporte {
    public static void main(String[] args) {
        //var g1 = new Gasto();
        //g1.tipoGasto = TipoDeGasto.DESAYUNO;
        //g1.monto =1000;
        List<Gasto> gastos = new ArrayList<>();
        var g1 = new Desayuno(1000);
        gastos.add(g1);
        var reporte = new ReporteDeGastos(gastos);
        //reporte.imprimir(List.of(g1));
        System.out.println(reporte.imprimir());
    }
}