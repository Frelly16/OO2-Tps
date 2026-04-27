package ejercicio1.main;

import ejercicio1.front.VentanaParticipante;
import ejercicio1.model.DBConnector;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DBConnector conector = new DBConnector();
                    new VentanaParticipante(conector);
                } catch (Exception e) {
                    System.out.println("Error al iniciar: " + e.getMessage());
                }
            }
        });
    }
}