package ejercicio1;

public class MotorEconomico implements Motor {
    @Override
    public void arrancar() {
        System.out.println("Arrancando motor económico");
    }

    @Override
    public void acelerar() {
        System.out.println("Acelerando motor económico");
    }

    @Override
    public void apagar() {
        System.out.println("Apagando motor económico");
    }
}