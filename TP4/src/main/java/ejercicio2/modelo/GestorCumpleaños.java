package ejercicio2.modelo;

import ejercicio2.service.EmailService;

import java.time.LocalDate;
import java.util.List;

public class GestorCumpleaños {
    private final LectorEmpleados empleados;
    private final Notificador notificador;
    private static final String URL = "";


    public GestorCumpleaños(LectorEmpleados empleados, Notificador notificador) {
        this.empleados = empleados;
        this.notificador = notificador;
    }

    public void enviarSaludo() {
        List<Empleado> todosLosEmpleados = empleados.cargarEmpleados();

        for(Empleado unEmpleado : todosLosEmpleados) {
            if (esSuCumpleaños(unEmpleado)) {
                String mensaje = "¡Feliz cumpleaños " + unEmpleado.nombre() + "!";
                String destinatario = unEmpleado.email();
                notificador.enviarSaludo(destinatario, mensaje);
            }
        }
    }

    private boolean esSuCumpleaños(Empleado unEmpleado) {
        return unEmpleado.fechaNacimiento().equals(LocalDate.now());
    }
}


