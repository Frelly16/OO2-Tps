package concursoTest.punto4;

import punto4.concurso.service.EmailService;

import java.util.ArrayList;
import java.util.List;

public class FakeEmailService extends EmailService {
    private final List<String> enviados = new ArrayList<>();

    public FakeEmailService() {
        super("fakeUser", "fakePass", "fakeHost", 0);
    }
    @Override
    public void mandarEmail(String destinatario, String asunto, String cuerpo) {
        enviados.add("Para: " + destinatario + " ASUNTO: " + asunto + " MENSAJE: " + cuerpo);
    }

    public List<String> getEnviados() {
        return enviados;
    }
}
