import ejercicio2.modelo.Notificador;

public class FakeNotificador implements Notificador {
    protected boolean seEnvioMail = false;
    protected String destinatario = "";
    protected String mensaje = "";
    @Override
    public void enviarSaludo(String destinatario, String mensaje) {
        this.seEnvioMail = true;
        this.destinatario = destinatario;
        this.mensaje = mensaje;
    }
}
