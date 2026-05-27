package ejercicio3;

import java.io.File;

public class ReporteNoSobrescribible extends ReporteDecorador {

    public ReporteNoSobrescribible(Reporte reporteEnvuelto) {
        super(reporteEnvuelto);
    }

    @Override
    public void exportar(File archivo) {
        if (archivo != null && archivo.exists()) {
            throw new IllegalArgumentException("El archivo ya existe...");
        }

        super.exportar(archivo);
    }
}