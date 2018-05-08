package seclab.concurrency;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/4/18
 * Time: 20:50
 * Description: 生产者和消费者代码示例
 * <p>
 * 生产者生产数据到缓冲区中，消费者从缓冲区中取数据。
 * 如果缓冲区已经满了，则生产者线程阻塞；
 * 如果缓冲区为空，那么消费者线程阻塞。
 */
public class ProducerAndConsumerExample1 {

    public static void main(String[] args) {
        ProducerAndConsumerExample1 example = new ProducerAndConsumerExample1();
        Resource resource = example.new Resource();
        Consumer consumer1 = example.new Consumer(resource);
        Consumer consumer2 = example.new Consumer(resource);
        Producer producer1 = example.new Producer(resource);
//        Producer producer2 = example.new Producer(resource);
//        Producer producer3 = example.new Producer(resource);

        consumer1.start();
        consumer2.start();
        producer1.start();
//        producer2.start();
//        producer3.start();
    }

    // remove和add方法都用synchronized修饰，那么调用Resource方法时，就可以获得Resource的监视器
    class Resource {
        private int left = 0;
        private int size = 10;

        // 消费者调用，消费一个产品
        public synchronized void remove() {
            // 如果有产品,则允许消费者消费
            if (left > 0) {
                left--;
                System.out.println("consumer " + Thread.currentThread().getName() + " consumed one product, left = " + left);
                notifyAll(); // 消费者调用此方法后，如果调用了notifyAll，则释放了Resource的监视器锁，那么生产者就可以继续拿到Resource的锁为其生产产品
            } else { // 否则，没有资源则消费者线程进入等待状态
                try {
                    wait(); // 不能消费，则进入等待状态，使得其他生产者得以拿到Resource 的锁，为其生产产品。
                    System.out.println("consumer " + Thread.currentThread().getName() + " waiting...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public synchronized void add() {
            if (left < size) {
                left++;
                System.out.println("producer " + Thread.currentThread().getName() + " produced one product, left = " + left);
                notifyAll(); // 通知等待的消费者
            } else {
                try {
                    wait();
                    System.out.println("producer " + Thread.currentThread().getName() + " waiging...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Consumer extends Thread {
        private Resource resource;

        public Consumer(Resource resource) {
            this.resource = resource;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                resource.remove();
            }
        }
    }

    class Producer extends Thread {
        private Resource resource;

        public Producer(Resource resource) {
            this.resource = resource;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                resource.add();
            }
        }
    }
}
