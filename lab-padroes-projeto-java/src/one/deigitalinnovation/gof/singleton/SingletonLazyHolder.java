package one.deigitalinnovation.gof.singleton;
/*
 * Singleton "Lazy Holder"
 */
public class SingletonLazyHolder {

    private static class Holder {
        public static SingletonLazyHolder instance = new SingletonLazyHolder();
    }

    private SingletonLazyHolder(){}

    public static SingletonLazyHolder getInstance(){
        return  Holder.instance;
    }
}
