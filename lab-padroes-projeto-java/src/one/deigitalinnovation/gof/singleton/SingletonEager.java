package one.deigitalinnovation.gof.singleton;
/*
 * Singleton "apressado"
 */
public class SingletonEager {

    private static SingletonEager instance = new SingletonEager();

    private SingletonEager(){}

    public static SingletonEager getInstance(){
        return  instance;
    }
}
