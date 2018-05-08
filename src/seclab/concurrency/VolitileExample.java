package seclab.concurrency;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/4/19
 * Time: 11:07
 * Description:
 */
public class VolitileExample implements Runnable {
    private int value;
    private volatile boolean missed;

    public VolitileExample() {
        value = 10;
        missed = false;
    }

    public static void main(String[] args) {
        VolitileExample volitileExample = new VolitileExample();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread thread = new Thread(volitileExample);
        thread.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 修改两个值
        try {
            volitileExample.workMethod();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println("run thread...");

        while (value < 20) {
            if (missed) {
                int curValue = value; // value = 10

                // 同步代码块不做任何事情
                // 但是可以通知jvm将该线程中的所有变量的私有拷贝与共享内存中的原始值进行比较
                Object object = new Object();
                synchronized (object) {

                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int afterValue = value;
                System.out.println("in run() - see value=" + curValue + ", but rumor has it that it changed!");
                System.out.println("in run() - valueAfterSync=" + afterValue);
                break;
            }
        }
        System.out.println("run thread finished.");
    }

    // 主线程中运行
    public void workMethod() throws InterruptedException {
        System.out.println("entering workMethod()");
        System.out.println("in workMethod() - about to sleep for 2 seconds");
        Thread.sleep(6000);
        //仅在此改变value的值
        missed = true; // 此时对所有的线程未必可见, 所以while循环可能继续也可能退出
//        Thread.sleep(3000);
        System.out.println("in workMethod() - just set value=" + value);
        System.out.println("in workMethod() - about to sleep for 5 seconds");
        value = 50;
//        Thread.sleep(5000);
        // 仅在此改变missedIt的值， 立即对所有的线程可见，而且此时其他诸如value的共享变量也变得可见
        // 所以while循环在value立马变得可见时value=50，不满足循环条件，退出循环，内部不执行
        System.out.println("in workMethod() - just set missedIt=" + missed);
        System.out.println("in workMethod() - about to sleep for 3 seconds");
        Thread.sleep(3000);
        System.out.println("leaving workMethod()");
    }
}
