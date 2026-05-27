package ejercicio3.front;

import ejercicio3.datos.RepositorioConcursosTXT;
import ejercicio3.datos.RepositorioInscripcionesTXT;
import ejercicio3.datos.RepositorioInscripcionesDB;
import ejercicio3.model.RepositorioConcursos;
import ejercicio3.model.RepositorioInscripciones;
import javax.swing.SwingUtilities;

public class Main {
    public static final String HOST = "localhost";
    public static final String PORT = "3306";
    public static final String USER = "root";
    public static final String PASSWORD = "";
    public static final String DB_NAME = "ciccarelli_concursos_db";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                String url = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME;
                RepositorioConcursos repoC = new RepositorioConcursosTXT("src/main/resources/concursos.txt");

                RepositorioInscripciones repoI = new RepositorioInscripcionesTXT("src/main/resources/inscriptos.txt");
                //para la db
                //RepositorioInscripciones repoI = new RepositorioInscripcionesDB(url, USER, PASSWORD);

                new RadioCompetition(repoC, repoI);

            } catch (Exception e) {
                System.out.println("Error fatal de inicio: " + e.getMessage());
            }
        });
    }
}