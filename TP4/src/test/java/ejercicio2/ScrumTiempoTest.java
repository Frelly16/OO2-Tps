package ejercicio2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScrumTiempoTest {

    @Test
    @DisplayName("El tiempo de un Spike individual es equivalente a su tiempo base")
    public void calcularTiempoSpike() {
        ItemTrabajo spike = new Spike(5);

        int tiempoTotal = spike.calcularTiempo();

        assertEquals(5, tiempoTotal);
    }

    @Test
    @DisplayName("El tiempo total de un Proyecto suma las historias de usuario, tareas y spikes que contiene")
    public void calcularTiempoProyectoCompleto() {
        Proyecto proyecto = new Proyecto();
        HistoriaUsuario historiaLogin = new HistoriaUsuario();
        HistoriaUsuario historiaCarrito = new HistoriaUsuario();

        ItemTrabajo tareaBackend = new Tarea(8);
        ItemTrabajo tareaFrontend = new Tarea(4);
        ItemTrabajo tareaBd = new Tarea(2);
        ItemTrabajo spikeArquitectura = new Spike(10);

        historiaLogin.agregar(tareaBackend);
        historiaLogin.agregar(tareaFrontend);
        historiaCarrito.agregar(tareaBd);

        proyecto.agregar(historiaLogin);
        proyecto.agregar(historiaCarrito);
        proyecto.agregar(spikeArquitectura);

        int tiempoTotal = proyecto.calcularTiempo();

        assertEquals(24, tiempoTotal);
    }
}