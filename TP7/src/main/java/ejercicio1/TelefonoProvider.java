package ejercicio1;

import java.util.Set;

public interface TelefonoProvider {
    Set<Telefono> obtenerTelefonosDePersona(int idPersona);
}