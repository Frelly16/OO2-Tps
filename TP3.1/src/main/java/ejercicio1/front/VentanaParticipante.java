package ejercicio1.front;

import ejercicio1.model.Participante;
import ejercicio1.model.RegistroParticipantes;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class VentanaParticipante extends JFrame{
    private JTextField nombre;
    private JTextField telefono;
    private JTextField region;
    private final RegistroParticipantes registro;

    public VentanaParticipante(RegistroParticipantes registro) {
        this.registro = registro;
        setupUIComponents();
    }

    public void setupUIComponents() {
        setTitle("Add Participant");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.nombre = new JTextField(10);
        this.telefono = new JTextField(10);
        this.region = new JTextField(10);

        this.nombre.setText("");
        this.telefono.setText("");
        this.region.setText("China");

        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new FlowLayout());

        contentPane.add(new JLabel("Nombre: "));
        contentPane.add(nombre);
        contentPane.add(new JLabel("Telefono: "));
        contentPane.add(telefono);
        contentPane.add(new JLabel("Region: "));
        contentPane.add(region);

        JButton botonCargar = new JButton("Cargar");
        botonCargar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    onBotonCargar();
                } catch (SQLException el) {
                    throw new RuntimeException(el);
                }
            }
        });
        contentPane.add(botonCargar);
        setContentPane(contentPane);
        contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        pack();
        setVisible(true);
    }

    private void onBotonCargar() throws SQLException {
        try {
            Participante participante = new Participante(nombre.getText(), telefono.getText(), region.getText());
            registro.guardarParticipante(participante);
            JOptionPane.showMessageDialog(this, "Participante cargado con éxito");
            dispose();
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al guardar: " + e.getMessage());
        }
    }

}