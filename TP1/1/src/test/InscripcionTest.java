package test;

import concurso.Inscripcion;
import concurso.Participante;
import org.testng.annotations.Test;

import java.time.LocalDate;

import static org.testng.Assert.assertThrows;
import static org.testng.AssertJUnit.assertEquals;

public class InscripcionTest {

    @Test
    void inscribirParticipanteDentroDelRango(){
        LocalDate apertura = LocalDate.now().minusDays(5);
        LocalDate cierre = apertura.plusDays(5);
        Inscripcion inscripcion = new Inscripcion(apertura, cierre);
        Participante p1 = new Participante("Nahuel", "40010232");

        inscripcion.inscribirParticipante(p1, LocalDate.now());
        assertEquals(0, p1.verPuntos());
    }

    @Test
    void inscribirParticipantePrimerDia(){
        LocalDate apertura = LocalDate.now();
        LocalDate cierre = apertura.plusDays(5);
        Inscripcion inscripcion = new Inscripcion(apertura, cierre);
        Participante p1 = new Participante("Lucia", "42230944");

        inscripcion.inscribirParticipante(p1, LocalDate.now());

        assertEquals(10, p1.verPuntos());
    }

    @Test
    void inscribirParticipanteFueraDeRango(){
        LocalDate apertura = LocalDate.now().minusMonths(10);
        LocalDate cierre = apertura.plusDays(5);
        Inscripcion inscripcion = new Inscripcion(apertura, cierre);
        Participante p1 = new Participante("Pedro", "35912321");

        assertThrows(IllegalArgumentException.class, () -> inscripcion.inscribirParticipante(p1, LocalDate.now()));
    }

}
