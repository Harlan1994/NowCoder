package seclab.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
public class ProducerAndConsumerExample2 {

    public static void main(String[] args) {
        ProducerAndConsumerExample2 example = new ProducerAndConsumerExample2();

        Lock lock = new ReentrantLock();
        Condition producerCondition = lock.newCondition();
        Condition consumerCondition = lock.newCondition();
        Resource resource = example.new Resource(lock, producerCondition, consumerCondition);
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

        private Lock lock;

        private Condition producerCondition;
        private Condition consumerCondition;

        public Resource(Lock lock, Condition producerCondition, Condition consumerCondition) {
            this.lock = lock;
            this.producerCondition = producerCondition;
            this.consumerCondition = consumerCondition;
        }

        // 消费者调用，消费一个产品
        public void remove() {
            lock.lock();
            try {
                if (left > 0) {
                    left--;
                    System.out.println("consumer " + Thread.currentThread().getName() + " consumed one product, left = " + left);
                    consumerCondition.signalAll(); // 唤醒等待的生产者，可以继续生产
                } else { // 否则，没有资源则消费者线程进入等待状态
                    try {
                        producerCondition.await(); // 否则让生产者进入等待状态
                        System.out.println("consumer " + Thread.currentThread().getName() + " waiting...");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                lock.unlock();
            }
        }

        public synchronized void add() {
            lock.lock(); // 锁定

            try {
                if (left < size) {
                    left++;
                    System.out.println("producer " + Thread.currentThread().getName() + " produced one product, left = " + left);
                    producerCondition.signalAll();
                } else {
                    try {
                        consumerCondition.await();
                        System.out.println("producer " + Thread.currentThread().getName() + " waiging...");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                lock.unlock();
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
