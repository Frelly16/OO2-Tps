package ejercicio5;

import ejercicio5.service.EmailService;

public class FakeEmailService extends EmailService {
    public String destinatarioRegistrado = "";
    public String asuntoRegistrado = "";

    public FakeEmailService() {
        super("fakeUser", "fakePass", "fakeHost", 0);
    }

    @Override
    public void mandarEmail(String destinatario, String asunto, String cuerpo) {
        this.destinatarioRegistrado = destinatario;
        this.asuntoRegistrado = asunto;
    }
}
