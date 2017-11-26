package seclab.other;

/**
 * User: Harlan1994
 * Date: 2017/9/6
 * Time: 19:52
 * Description:
 */
public class StaticHolderSingleton {

    private StaticHolderSingleton() {
    }

    public static StaticHolderSingleton getInstance() {
        return InnerHolder.instance;
    }

    static class InnerHolder {
        private static StaticHolderSingleton instance = new StaticHolderSingleton();
    }
}