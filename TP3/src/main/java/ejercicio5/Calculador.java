package ejercicio5;

public class Calculador {

    public String reporte(Factura factura) {
        float totalAmount = 0;
        float creditos = 0;
        StringBuilder result = new StringBuilder("Facturación para " + factura.nombreCliente() + System.lineSeparator());
        var actuaciones = factura.actuaciones();
        for (Actuacion actuacion : actuaciones) {
            float monto = actuacion.calcularMonto();
            creditos += actuacion.calcularCredito();
            //throw new RuntimeException("Tipo de evento no conocido");
            result.append(actuacion.nombreEvento()).append(": ").append(monto)
                    .append(". Asientos: ").append(actuacion.numeroEspectadores()).append(System.lineSeparator());//` ${play.name}: ${format(thisAmount/100)} (${perf.audience} seats)\n`;
            totalAmount += monto;
        }
        result.append("Monto ganado: ").append(totalAmount).append(System.lineSeparator());
        result.append("Créditos ganados: ").append(creditos).append(System.lineSeparator());

        return result.toString();
    }
}