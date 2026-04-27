package ejercicio2;

public enum ColumnaCSV {
    PERMALINK("permalink", 0),
    COMPANY_NAME("company_name", 1),
    NUMBER_EMPLOYEES("number_employees", 2),
    CATEGORY("category", 3),
    CITY("city", 4),
    STATE("state", 5),
    FUNDED_DATE("funded_date", 6),
    RAISED_AMOUNT("raised_amount", 7),
    RAISED_CURRENCY("raised_currency", 8),
    ROUND("round", 9);


    private final String nombre;
    private final int indice;

    ColumnaCSV(String nombre, int indice) {
        this.nombre = nombre;
        this.indice = indice;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getIndice() {
        return this.indice;
    }

}
