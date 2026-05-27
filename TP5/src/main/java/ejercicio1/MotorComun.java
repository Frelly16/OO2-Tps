package ejercicio1;

public class MotorComun implements Motor {
    @Override
    public void arrancar() {
        System.out.println("Arrancando motor común");
    }

    @Override
    public void acelerar() {
        System.out.println("Acelerando motor común");
    }

    @Override
    public void apagar() {
        System.out.println("Apagando motor común");
    }
}