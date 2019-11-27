package Singleton;

public class LazySingleton {

    private LazySingleton() {
        System.err.println("Lazy Initializing Singleton");
    }

    private static LazySingleton INSTANCE = new LazySingleton();

    public static synchronized LazySingleton getInstance1() {

        if (INSTANCE == null) {
            return new LazySingleton();
        }
        return INSTANCE;
    }

    // double check locking
    public static LazySingleton getInstance() {

        if (INSTANCE == null) {
            synchronized (LazySingleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LazySingleton();
                }
            }
        }
        return INSTANCE;
    }
}
