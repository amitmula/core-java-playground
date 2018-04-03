package multithreading.concurrencyUtils.blockingQueues.ArrayBlockingQueue;

import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ArrayBlockingQueueDemo {

    BlockingQueue<String> arrayBlockingQueue;

    public ArrayBlockingQueueDemo() {
        this.arrayBlockingQueue = new ArrayBlockingQueue(5);
    }

    public static void main(String args[]) throws InterruptedException {
        ArrayBlockingQueueDemo demo = new ArrayBlockingQueueDemo();
        Thread producer = new Thread(new Producer(demo.arrayBlockingQueue), "ProducerThread");
        Thread consumer = new Thread(new Consumer(demo.arrayBlockingQueue), "ConsumerThread");
        producer.start();
        consumer.start();
    }
}

class Producer implements Runnable {

    BlockingQueue queue;

    public Producer(BlockingQueue _queue) {
        this.queue = _queue;
    }

    public void run() {
        while(true) {
            try {
                String element  = UUID.randomUUID().toString();
                System.out.println("Producing element : " + element);
                queue.put(element);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {

    BlockingQueue queue;

    public Consumer(BlockingQueue _queue) {
        this.queue = _queue;
    }

    public void run() {

        while(true) {
            try {
                String element = (String) queue.take();
                System.out.println("Consuming element : " + element);
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}