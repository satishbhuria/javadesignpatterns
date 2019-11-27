package Adaptor;

public class Demo {

    public static void main(String[] args) {

        Movable bmw = new BMW();
        MovableAdaptor bmwAdaptor = new MovableAdaptorImpl(bmw);

        double speed = bmwAdaptor.getSpeed();

        System.out.println(speed);
    }
}
