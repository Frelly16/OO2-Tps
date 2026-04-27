package ejercicio2;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LectorDeDatosCSV {
    private final String urlArchivo;

    public LectorDeDatosCSV(String urlArchivo) {
        this.urlArchivo = urlArchivo;
    }

    public List<String[]> leerArchivo() throws IOException {
        List<String[]> csvData = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(urlArchivo))) {
            String[] row = null;
            while ((row = reader.readNext()) != null) {
                csvData.add(row);
            }
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
        if (!csvData.isEmpty()) {
            csvData.removeFirst();
        }
        return csvData;
    }


}
