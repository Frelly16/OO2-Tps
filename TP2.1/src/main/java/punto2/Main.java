package punto2;

public class Main {
    public static void main(String[] args) {
        AprendiendoLambdas a = new AprendiendoLambdas();

        // a.
        System.out.print("¿Es largo par?: ");
        a.unMetodo(s -> s.length() % 2 == 0);

        // b.
        System.out.print("¿Empieza con 'a'?: ");
        a.unMetodo(s -> s.startsWith("a"));
    }
}