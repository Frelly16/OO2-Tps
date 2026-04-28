package ejercicio3.front;

import ejercicio3.model.Concurso;
import ejercicio3.model.Participante;
import ejercicio3.model.RepositorioConcursos;
import ejercicio3.model.RepositorioInscripciones;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RadioCompetition extends JFrame {
    private final RepositorioConcursos repoConcursos;
    private final RepositorioInscripciones repoInscripciones;

    private final JPanel contentPane;
    private JTextField txtName, txtLastName, txtId, txtPhone, txtEmail;
    private JComboBox<Concurso> comboBox; // Tipamos el combo
    private JButton btnOk;

    public RadioCompetition(RepositorioConcursos repoConcursos, RepositorioInscripciones repoInscripciones) {
        this.repoConcursos = repoConcursos;
        this.repoInscripciones = repoInscripciones;

        setTitle("Inscription to Competition");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 451, 250);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        formElements();
        layoutUI();
        setVisible(true);
    }

    private void formElements() {
        txtName = new JTextField(10);
        txtLastName = new JTextField(10);
        txtId = new JTextField(10);
        txtPhone = new JTextField(10);
        txtEmail = new JTextField(10);

        comboBox = new JComboBox<>();
        cargarConcursos();

        btnOk = new JButton("Ok");
        btnOk.addActionListener(e -> {
            btnOk.setEnabled(false);
            saveInscription();
            btnOk.setEnabled(true);
        });
    }

    private void cargarConcursos() {
        List<Concurso> abiertos = repoConcursos.concursosAbiertos();
        for (Concurso c : abiertos) {
            comboBox.addItem(c);
        }
    }

    private void saveInscription() {
        try {
            Participante nuevoParticipante = new Participante(
                    txtName.getText(),
                    txtLastName.getText(),
                    txtId.getText(),
                    txtPhone.getText(),
                    txtEmail.getText()
            );

            Concurso concursoElegido = (Concurso) comboBox.getSelectedItem();
            if (concursoElegido == null) {
                throw new IllegalArgumentException("Debe elegir un Concurso");
            }

            repoInscripciones.guardar(nuevoParticipante, concursoElegido);
            JOptionPane.showMessageDialog(this, "¡Inscripción exitosa!");

        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de Validación", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error técnico: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void layoutUI() {
        JLabel lblName = new JLabel("Nombre:");
        JLabel lblLastName = new JLabel("Apellido:");
        JLabel lblId = new JLabel("Dni:");
        JLabel lblPhone = new JLabel("Telefono:");
        JLabel lblEmail = new JLabel("Email:");
        JLabel lblCompetition = new JLabel("Concurso:");

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(gl_contentPane
                .createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
                        .addGroup(gl_contentPane
                                .createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
                                        .createSequentialGroup()
                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                .addComponent(lblLastName).addComponent(lblId)
                                                .addComponent(lblPhone).addComponent(lblEmail)
                                                .addComponent(lblName).addComponent(lblCompetition))
                                        .addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                        .addGroup(
                                                gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                        .addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(txtEmail, Alignment.TRAILING)
                                                        .addComponent(txtPhone, Alignment.TRAILING)
                                                        .addComponent(txtId, Alignment.TRAILING)
                                                        .addComponent(txtLastName, Alignment.TRAILING)
                                                        .addComponent(txtName, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)))
                                .addComponent(btnOk, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap()));

        gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                .addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblName))
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                .addComponent(lblLastName).addComponent(txtLastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                .addComponent(lblId).addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                .addGroup(gl_contentPane.createSequentialGroup().addComponent(lblPhone)
                                        .addPreferredGap(ComponentPlacement.UNRELATED)
                                        .addComponent(lblEmail))
                                .addGroup(gl_contentPane.createSequentialGroup()
                                        .addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(ComponentPlacement.RELATED)
                                        .addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(ComponentPlacement.RELATED).addGroup(
                                                gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblCompetition))))
                        .addPreferredGap(ComponentPlacement.RELATED).addComponent(btnOk)
                        .addContainerGap(67, Short.MAX_VALUE)));
        contentPane.setLayout(gl_contentPane);
    }
}