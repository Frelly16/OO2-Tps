package ejercicio3;

import java.io.File;

public abstract class ReporteDecorador implements Reporte {
    protected final Reporte reporteEnvuelto;

    public ReporteDecorador(Reporte reporteEnvuelto) {
        this.reporteEnvuelto = reporteEnvuelto;
    }

    @Override
    public void exportar(File archivo) {
        reporteEnvuelto.exportar(archivo);
    }
}