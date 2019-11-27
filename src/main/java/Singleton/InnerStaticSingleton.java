package Singleton;

class InnerStaticSingleton {

    private InnerStaticSingleton() {
    }

    private static class impl {
        private static final InnerStaticSingleton INSTANCE = new InnerStaticSingleton();
    }

    public InnerStaticSingleton getInstance() {
        return impl.INSTANCE;
    }
}
