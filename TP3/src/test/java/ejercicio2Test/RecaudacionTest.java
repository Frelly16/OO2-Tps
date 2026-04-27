package ejercicio2Test;

import ejercicio2.ColumnaCSV;
import ejercicio2.Recaudacion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecaudacionTest {

    private Recaudacion recaudacion;

    @BeforeEach
    public void setUp() throws IOException {
        this.recaudacion = new Recaudacion();
    }

    @Test
    public void testWhereGivenCompany() {
        Map<String, String> options = new HashMap<>();
        options.put(ColumnaCSV.COMPANY_NAME.getNombre(), "Facebook");

        assertEquals(7, recaudacion.where(options).size());
    }

    @Test
    public void testWhereGivenCity() {
        Map<String, String> options = new HashMap<>();
        options.put(ColumnaCSV.CITY.getNombre(), "Tempe");

        assertEquals(3, recaudacion.where(options).size());
    }

    @Test
    public void testWhereGivenState() {
        Map<String, String> options = new HashMap<>();
        options.put(ColumnaCSV.STATE.getNombre(), "CA");

        assertEquals(873, recaudacion.where(options).size());
    }

    @Test
    public void testWhereGivenRound() {
        Map<String, String> options = new HashMap<>();
        options.put(ColumnaCSV.ROUND.getNombre(), "a");

        assertEquals(582, recaudacion.where(options).size());
    }

    @Test
    public void testMultipleOptions() {
        Map<String, String> options = new HashMap<>();
        options.put(ColumnaCSV.ROUND.getNombre(), "a");
        options.put(ColumnaCSV.COMPANY_NAME.getNombre(), "Facebook");

        assertEquals(1, recaudacion.where(options).size());
    }

    @Test
    public void testWhereNotExists() {
        Map<String, String> options = new HashMap<>();
        options.put(ColumnaCSV.COMPANY_NAME.getNombre(), "NotFacebook");

        assertEquals(0, recaudacion.where(options).size());
    }

    @Test
    public void testWhereCorrectKeys() {
        Map<String, String> options = new HashMap<>();
        options.put(ColumnaCSV.COMPANY_NAME.getNombre(), "Facebook");

        Map<String, String> row = recaudacion.where(options).getFirst();

        assertEquals("facebook", row.get(ColumnaCSV.PERMALINK.getNombre()));
        assertEquals("Facebook", row.get(ColumnaCSV.COMPANY_NAME.getNombre()));
        assertEquals("450", row.get("number_employees")); // Puedes reemplazar estos strings por el Enum también
        assertEquals("web", row.get("category"));
        assertEquals("Palo Alto", row.get(ColumnaCSV.CITY.getNombre()));
        assertEquals("CA", row.get(ColumnaCSV.STATE.getNombre()));
        assertEquals("1-Sep-04", row.get("funded_date"));
        assertEquals("500000", row.get("raised_amount"));
        assertEquals("angel", row.get(ColumnaCSV.ROUND.getNombre()));
    }
}