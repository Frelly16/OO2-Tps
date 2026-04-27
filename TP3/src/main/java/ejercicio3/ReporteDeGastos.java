package ejercicio3;

import java.time.LocalDate;
import java.util.List;

public class ReporteDeGastos {
    private final List<Gasto> gastos;

    public ReporteDeGastos(List<Gasto> gastos) {
        this.gastos = gastos;
    }

    public String imprimir() {
        int total = 0;
        int gastosDeComida = 0;
        StringBuilder reporte = new StringBuilder();

        reporte.append("Expenses ").append(LocalDate.now()).append("\n");

        for (Gasto gasto : gastos) {
            gastosDeComida += gasto.montoComida();
            String nombreGasto = gasto.nombreGasto();
            String marcaExcesoComidas = gasto.marcaComidaPorExceso();

            reporte.append(nombreGasto).append("\t")
                    .append(gasto.monto).append("\t")
                    .append(marcaExcesoComidas).append("\n");

            total += gasto.monto;
        }

        reporte.append("Gastos de comida: ").append(gastosDeComida).append("\n");
        reporte.append("Total de gastos: ").append(total).append("\n");

        return reporte.toString();
    }
}