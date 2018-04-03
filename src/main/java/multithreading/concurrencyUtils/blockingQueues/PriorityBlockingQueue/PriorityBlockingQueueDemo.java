package multithreading.concurrencyUtils.blockingQueues.PriorityBlockingQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by amit.k.mula on 12/3/17.
 */

class Producer implements Runnable {

    BlockingQueue queue;
    ArrayList<String> elementsToPut;

    public Producer(BlockingQueue queue, List<String> elements) {
        this.queue = queue;
        this.elementsToPut = (ArrayList<String>) elements;
    }

    public void run() {
        Iterator<String> iterator = elementsToPut.iterator();
        while(iterator.hasNext()) {
            String element = iterator.next();
            System.out.println("Producing element : " + element);
            ((PriorityBlockingQueue)queue).put(element);
        }
    }
}

class Consumer implements Runnable {
    BlockingQueue queue;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        while(queue.size() > 0) {
            try {
                String element = (String) queue.take();
                System.out.println("Consuming element : " + element);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class PriorityBlockingQueueDemo {

    public static void main(String args[]) throws InterruptedException {
        List<String> names  = new ArrayList<String>();
        names.add("ABC");
        names.add("DEF");
        names.add("GHI");
        names.add("JKL");
        names.add("MNO");
        names.add("PQR");
        names.add("STU");

        Collections.reverse(names);

        BlockingQueue priorityBlockingQueue = new PriorityBlockingQueue(names.size());

        Thread producerThread = new Thread(new Producer(priorityBlockingQueue, names));
        Thread consumerThread = new Thread(new Consumer(priorityBlockingQueue));

        producerThread.start();
        Thread.sleep(10);
        consumerThread.start();

        consumerThread.join();
    }


}
