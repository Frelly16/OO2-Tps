package ejercicio2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Recaudacion {
    private final List<String[]> csvData;

    public Recaudacion() throws IOException {
        LectorDeDatosCSV lector = new LectorDeDatosCSV("src/main/resources/data.csv");
        this.csvData = lector.leerArchivo();
    }

    public List<Map<String, String>> where(Map<String, String> options) {
        List<String[]> datosFiltrados = this.csvData;

        if (options.containsKey("company_name")) {
            String valorBuscado = options.get(ColumnaCSV.COMPANY_NAME.getNombre());
            datosFiltrados = filtrarDatos(datosFiltrados, ColumnaCSV.COMPANY_NAME, valorBuscado);
        }

        if (options.containsKey("city")) {
            String valorBuscado = options.get(ColumnaCSV.CITY.getNombre());
            datosFiltrados = filtrarDatos(datosFiltrados, ColumnaCSV.CITY, valorBuscado);
        }

        if (options.containsKey("state")) {
            String valorBuscado = options.get(ColumnaCSV.STATE.getNombre());
            datosFiltrados = filtrarDatos(datosFiltrados, ColumnaCSV.STATE, valorBuscado);
        }

        if (options.containsKey(ColumnaCSV.ROUND.getNombre())) {
            String valorBuscado = options.get(ColumnaCSV.ROUND.getNombre());
            datosFiltrados = filtrarDatos(datosFiltrados, ColumnaCSV.ROUND, valorBuscado);
        }
        return mapearResultados(datosFiltrados);
    }

    private List<String[]> filtrarDatos(List<String[]> datos, ColumnaCSV columna, String valorBuscado) {
        List<String[]> results = new ArrayList<>();
        for (String[] fila : datos) {
            if (fila[columna.getIndice()].equals(valorBuscado)) {
                results.add(fila);
            }
        }

        return results;
    }

    private static List<Map<String, String>> mapearResultados(List<String[]> datosFiltrados) {
        List<Map<String, String>> output = new ArrayList<>();
        // Dejo las dos formas para clarificar el uso del foreach. Originalmente hice el put a mano,
        // y para simplificarlo usé el foreach anidado.
        for (String[] fila : datosFiltrados) {
            Map<String, String> mapped = new HashMap<>();
            //mapped.put(ColumnaCSV.PERMALINK.getNombre(), fila[ColumnaCSV.PERMALINK.getIndice()]);
            //mapped.put(ColumnaCSV.COMPANY_NAME.getNombre(), fila[ColumnaCSV.COMPANY_NAME.getIndice()]);
            //mapped.put(ColumnaCSV.NUMBER_EMPLOYEES.getNombre(), fila[ColumnaCSV.NUMBER_EMPLOYEES.getIndice()]);
            //mapped.put(ColumnaCSV.CATEGORY.getNombre(), fila[ColumnaCSV.CATEGORY.getIndice()]);
            //mapped.put(ColumnaCSV.CITY.getNombre(), fila[ColumnaCSV.CITY.getIndice()]);
            //mapped.put(ColumnaCSV.STATE.getNombre(), fila[ColumnaCSV.STATE.getIndice()]);
            //mapped.put(ColumnaCSV.FUNDED_DATE.getNombre(), fila[ColumnaCSV.FUNDED_DATE.getIndice()]);
            //mapped.put(ColumnaCSV.RAISED_AMOUNT.getNombre(), fila[ColumnaCSV.RAISED_AMOUNT.getIndice()]);
            //mapped.put(ColumnaCSV.RAISED_CURRENCY.getNombre(), fila[ColumnaCSV.RAISED_CURRENCY.getIndice()]);
            //mapped.put(ColumnaCSV.ROUND.getNombre(), fila[ColumnaCSV.ROUND.getIndice()]);
            for (ColumnaCSV columna : ColumnaCSV.values()) {
                mapped.put(columna.getNombre(), fila[columna.getIndice()]);
            }
            output.add(mapped);
        }
        return output;
    }
}