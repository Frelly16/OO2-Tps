package punto3.main;

import punto3.concurso.logger.ArchivoInscripcionLogger;
import punto3.concurso.logger.DBInscripcionLogger;
import punto3.concurso.logger.InscripcionLogger;
import punto3.concurso.modelo.Inscripcion;
import punto3.concurso.modelo.Participante;
import punto3.restaurante.logger.ArchivoRestauranteLogger;
import punto3.restaurante.logger.DBRestauranteLogger;
import punto3.restaurante.logger.RestauranteLogger;
import punto3.restaurante.modelo.*;
import punto3.restaurante.tarjeta.Visa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/ciccarelli_tp2";
    private static final String USER = "root";
    private static final String PASS = "";

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Registrar inscripciones en Archivo (1) o en Base de Datos (2) ?");
            opcion = scanner.nextInt();
        } while (opcion != 1 && opcion != 2);
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

        InscripcionLogger inscripcionLogger = (opcion == 1)
                ? new ArchivoInscripcionLogger("inscripciones.txt")
                : new DBInscripcionLogger(conn);

        RestauranteLogger restauranteLogger = (opcion == 1)
                ? new ArchivoRestauranteLogger("consumos.txt")
                : new DBRestauranteLogger(conn);

        // Ejemplo para Concurso

        Inscripcion inscripcion = new Inscripcion(LocalDate.now(), LocalDate.now().plusDays(5), "Concurso2026", inscripcionLogger);
        Participante p1 = new Participante("Juan", "29011821");
        Participante p2 = new Participante("Laura", "40621999");
        inscripcion.inscribirParticipante(p1, LocalDate.now());
        inscripcion.inscribirParticipante(p2, LocalDate.now());

        // Ejemplo para Restaurante

        Pedido pedido = new Pedido();
        pedido.agregarItem(new MenuItem("Guiso", 18450, TipoItem.PLATO));
        pedido.agregarItem(new MenuItem("Agua", 1200, TipoItem.BEBIDA));
        Pago pago = new Pago(pedido, new Visa(), Propina.CINCO, restauranteLogger);
        double total = pago.calcularTotal();
    }
}
