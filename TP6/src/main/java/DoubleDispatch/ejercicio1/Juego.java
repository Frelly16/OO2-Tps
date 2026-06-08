package DoubleDispatch.ejercicio1;

import java.util.Random;
import java.util.Scanner;

public class Juego {
    private final String[] opciones = {"piedra", "papel", "tijera"};
    private final Scanner scanner = new Scanner(System.in);

    public void iniciar() {
        boolean continuar = true;
        while (continuar) {
            Elemento eleccionUsuario = elegirElementoUsuario();
            Elemento eleccionComputadora = elegirElementoComputadora();

            System.out.println("Tu elección: " + eleccionUsuario.getClass().getSimpleName().toLowerCase());
            System.out.println("Elección de la computadora: " + eleccionComputadora.getClass().getSimpleName().toLowerCase());

            System.out.println(new Jugada().jugar(eleccionUsuario, eleccionComputadora));

            continuar = preguntarSiQueremosContinuar();
        }

        System.out.println("¡Hasta pronto!");
        scanner.close();
    }

    private Elemento elegirElementoUsuario() {
        System.out.println("Elige una opción: piedra, papel o tijera");
        String eleccion = scanner.nextLine().toLowerCase();
        return instanciarElemento(eleccion);
    }

    private Elemento elegirElementoComputadora() {
        Random random = new Random();
        int indice = random.nextInt(3);
        return instanciarElemento(opciones[indice]);
    }

    private Elemento instanciarElemento(String opcion) {
        if (opcion.equals("piedra")) return new Piedra();
        if (opcion.equals("papel")) return new Papel();
        return new Tijera();
    }

    private boolean preguntarSiQueremosContinuar() {
        System.out.println("¿Desea continuar? s/n");
        String respuesta = scanner.nextLine();
        return respuesta.toLowerCase().charAt(0) == 's';
    }
}