package multithreading.concurrencyUtils.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by amit.k.mula on 12/3/17.
 */

class Waiter implements Runnable {
    CountDownLatch countDownLatch;
    public Waiter(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }
    public void run() {
        try {
            System.out.println("Waiter thread is waiting for countDownLatch to come to zero.");
            countDownLatch.await();
            System.out.println("Executing waiter thread now.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Decrementer implements Runnable {

    CountDownLatch countDownLatch;
    int n;

    public Decrementer(CountDownLatch countDownLatch, int n) {
        this.countDownLatch = countDownLatch;
        this.n = n;
    }

    public void run() {
        try {
            do {
                System.out.println("Seconds to resume waiter thread : " + n);
                Thread.sleep(1000);
                this.countDownLatch.countDown();
            } while(--n > -1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class CountDownLatchDemo {
    public static void main(String args[]) {
        int n = 10;
        System.out.println("Initiating countDownLatch to " + n);
        CountDownLatch countDownLatch = new CountDownLatch(n);

        Thread decrementerThread = new Thread(new Decrementer(countDownLatch, n));
        Thread waiterThread = new Thread(new Waiter(countDownLatch));
        waiterThread.start();
        decrementerThread.start();
    }
}
