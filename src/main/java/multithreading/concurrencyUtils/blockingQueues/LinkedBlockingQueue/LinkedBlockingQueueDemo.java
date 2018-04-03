package multithreading.concurrencyUtils.blockingQueues.LinkedBlockingQueue;

import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

class Producer implements Runnable {
    BlockingQueue queue;
    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        while(true) {
            try {
                String element = UUID.randomUUID().toString();
                System.out.println("Producing element : " + element);
                ((LinkedBlockingQueue)queue).put(element);
                System.out.println("Queue Size: " + queue.size() + " | " + queue);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    BlockingQueue queue;
    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }
    public void run() {
        while(true) {
            try {
                String element = (String) queue.poll(500, TimeUnit.MICROSECONDS);
                System.out.println("Consuming element : " + element);
                System.out.println("Queue Size: " + queue.size() + " | " + queue);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class LinkedBlockingQueueDemo {
    static BlockingQueue<String> linkedBlockingQueue;
    public static void main(String args[]) {
        linkedBlockingQueue = new LinkedBlockingQueue<String>(5);
        Thread producerThread = new Thread(new Producer(linkedBlockingQueue));
        Thread consumerThread = new Thread(new Consumer(linkedBlockingQueue));
        consumerThread.start();
        producerThread.start();
    }
}
