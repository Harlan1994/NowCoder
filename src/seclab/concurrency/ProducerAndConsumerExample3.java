package seclab.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

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
public class ProducerAndConsumerExample3 {

    public static void main(String[] args) {
        ProducerAndConsumerExample3 example = new ProducerAndConsumerExample3();
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
        private BlockingQueue queue = new LinkedBlockingDeque(10);

        // 消费者调用，消费一个产品
        public synchronized void remove() {
            // 如果有产品,则允许消费者消费
            try {
                queue.put(1);
                System.out.println("consumer " + Thread.currentThread().getName() + " consumed one product, left = " + queue.size());
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        public synchronized void add() {
            // 如果有产品,则允许消费者消费
            try {
                queue.take();
                System.out.println("producer " + Thread.currentThread().getName() + " produced one product, left = " + queue.size());
            }catch (InterruptedException e){
                e.printStackTrace();
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
