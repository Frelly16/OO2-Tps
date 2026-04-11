package punto3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Personas {

    private List<Persona> filtrar(List<Persona> personas, Predicate<Persona> condicion) {
        List<Persona> resultado = new ArrayList<>();
        for (Persona persona : personas) {
            if (condicion.test(persona)) {
                resultado.add(persona);
            }
        }
        return resultado;
    }

    public List<Persona> nombresQueEmpiezanConE(List<Persona> p) {
        return filtrar(p, persona -> persona.nombre().startsWith("E"));
    }

    public List<Persona> nombresCuyaCantidadDeLetrasEsPar(List<Persona> p) {
        return filtrar(p, persona -> persona.nombre().length() % 2 == 0);
    }
}