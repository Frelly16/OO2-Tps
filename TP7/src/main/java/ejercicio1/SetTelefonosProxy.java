package ejercicio1;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;

public class SetTelefonosProxy extends AbstractSet<Telefono> {
    private Set<Telefono> telefonosReales;
    private final int idPersona;
    private final TelefonoProvider provider;

    public SetTelefonosProxy(int idPersona, TelefonoProvider provider) {
        this.idPersona = idPersona;
        this.provider = provider;
    }

    private void inicializarSiEsNecesario() {
        if (telefonosReales == null) {
            telefonosReales = provider.obtenerTelefonosDePersona(idPersona);
        }
    }

    @Override
    public Iterator<Telefono> iterator() {
        inicializarSiEsNecesario();
        return telefonosReales.iterator();
    }

    @Override
    public int size() {
        inicializarSiEsNecesario();
        return telefonosReales.size();
    }
}