package seclab.other;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by sjk on 2017/10/10.
 */
public class Producer implements Runnable {
    Queue<Integer> queue;

    public Producer(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        synchronized (queue) {
            while (queue.size() == 10) { // 一直等待到非 10
                System.out.println("生产者等待");
                try {
                    queue.wait();
                    System.out.println(0.0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // 生产，并且在库存从 0 到 1 的过程中通知被阻塞的消费者
            int product = (int) (Math.random() * 10);

            System.out.println("生产者生产：" + product);
            queue.add(product);
            if (queue.size() == 1) {
                queue.notify();
            }
        }
    }

    static class Consumer implements Runnable {
        Queue<Integer> queue;

        public Consumer(Queue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            synchronized (queue) {
                while (queue.size() == 0) {
                    try {
                        System.out.println("消费者等待");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // 消费，并且在库存从 10 到 9 的过程中通知被阻塞的生产者
                System.out.println("消费者消费：" + queue.poll());
                if (queue.size() == 9) {
                    queue.notify();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Queue queue = new LinkedList();
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        List<Thread> producerList = new ArrayList<>(), consumerList = new ArrayList<>();

        for (int i = 0; i < 11; i++) {
            producerList.add(new Thread(producer));
        }

        for (Thread thread : producerList) {
            thread.start();
        }

//        Thread.sleep(100);

//        for (int i = 0; i < 10; i++) {
//            consumerList.add(new Thread(consumer));
//        }
//
//        for (Thread thread : consumerList) {
//            thread.start();
//        }
    }
}
