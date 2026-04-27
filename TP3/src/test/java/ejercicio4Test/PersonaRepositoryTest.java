package ejercicio4Test;

import ejercicio4.Persona;
import ejercicio4.PersonaRepository;
import ejercicio4.SetUpDatabase;
import org.jdbi.v3.core.Jdbi;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class PersonaRepositoryTest {

    private PersonaRepository repo;

    @BeforeEach
    public void setUp() {
        Jdbi jdbi = Jdbi.create("jdbc:hsqldb:mem;create=true");
        new SetUpDatabase(jdbi).setUp();
        this.repo = new PersonaRepository(jdbi);
    }

    @Test
    public void buscarPorNombreExistente() {
        List<Persona> resultados = repo.buscarPorNombre("Vla");

        assertEquals(1, resultados.size());
        assertEquals("Vladimir", resultados.getFirst().nombre());
        assertEquals("Varkov", resultados.getFirst().apellido());
    }

    @Test
    public void buscarPorNombreNoExistente() {
        List<Persona> resultados = repo.buscarPorNombre("ZXCV");

        assertNotNull(resultados);
        assertTrue(resultados.isEmpty());
    }

    @Test
    public void buscarPorIDExistente() {
        Optional<Persona> resultado = repo.buscarId(1L);
        assertTrue(resultado.isPresent());
        assertEquals("José", resultado.get().nombre());
        assertEquals("Laurenti", resultado.get().apellido());
    }

    @Test
    public void buscarPorIDNoExistente() {
        Optional<Persona> resultado = repo.buscarId(99L);
        assertNotNull(resultado);
        assertTrue(resultado.isEmpty());
    }


}
