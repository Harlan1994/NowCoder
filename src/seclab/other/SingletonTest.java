package seclab.other;

/**
 * User: Harlan1994
 * Date: 2017/9/6
 * Time: 19:54
 * Description:
 */
public class SingletonTest {

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            System.out.println(StaticHolderSingleton.getInstance());
                        }
                    }
            ).start();
        }
    }
}