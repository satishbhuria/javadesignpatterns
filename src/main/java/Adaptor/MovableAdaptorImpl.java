package Adaptor;

public class MovableAdaptorImpl implements MovableAdaptor{

    private Movable luxuryCars;

    public MovableAdaptorImpl(Movable luxuryCars) {
        this.luxuryCars = luxuryCars;
    }

    // standard constructors

    @Override
    public double getSpeed() {
        return convertMPHtoKMPH(luxuryCars.getSpeed());
    }

    private double convertMPHtoKMPH(double mph) {
        return mph * 1.60934;
    }
}
