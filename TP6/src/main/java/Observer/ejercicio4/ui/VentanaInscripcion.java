package Observer.ejercicio4.ui;

import Observer.ejercicio4.modelo.Concurso;
import Observer.ejercicio4.modelo.NotificadorEmailObserver;
import Observer.ejercicio4.modelo.Participante;
import Observer.ejercicio4.service.EmailService;

import javax.swing.*;
import java.awt.*;

public class VentanaInscripcion extends JFrame {
    private JTextField txtNombre;
    private JTextField txtDni;
    private JTextField txtEmail;
    private JButton btnInscribir;
    private final Concurso concurso;

    public VentanaInscripcion(Concurso concurso) {
        this.concurso = concurso;
        configurarVentana();
        configurarEventos();
    }

    private void configurarVentana() {
        setTitle("Inscripción al Concurso");
        setLayout(new GridLayout(4, 2, 10, 10));
        getRootPane().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        add(txtNombre);

        add(new JLabel("DNI:"));
        txtDni = new JTextField();
        add(txtDni);

        add(new JLabel("Email:"));
        txtEmail = new JTextField();
        add(txtEmail);

        add(new JLabel(""));
        btnInscribir = new JButton("Inscribirse");
        add(btnInscribir);

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void configurarEventos() {
        btnInscribir.addActionListener(e -> {
            try {
                Participante nuevoParticipante = new Participante(
                        txtNombre.getText(),
                        txtDni.getText(),
                        txtEmail.getText()
                );

                concurso.inscribir(nuevoParticipante);

                JOptionPane.showMessageDialog(this, "Inscripción registrada. Se enviará un correo de confirmación.");
                limpiarCampos();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Ocurrió un error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtDni.setText("");
        txtEmail.setText("");
    }

    public static void main(String[] args) {
        Concurso concursoTorneo = new Concurso("Torneo 2026");

        EmailService mailtrap = new EmailService("425a926065d951", "0c4b20791054dd", "sandbox.smtp.mailtrap.io", 587);
        concursoTorneo.agregarObservador(new NotificadorEmailObserver(mailtrap));

        SwingUtilities.invokeLater(() -> {
            new VentanaInscripcion(concursoTorneo).setVisible(true);
        });
    }
}