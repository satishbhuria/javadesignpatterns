package Singleton;

public class SingletonDemo {

    private SingletonDemo() {

    }

    private static final SingletonDemo INSTANCE = new SingletonDemo();

    public static SingletonDemo getInstance() {
        return INSTANCE;
    }

    private int value = 0;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

class demo {
    public static void main(String[] args) {

        SingletonDemo singletonDemo =  SingletonDemo.getInstance();
        singletonDemo.setValue(10);

        System.out.println(singletonDemo.getValue());
    }
}
