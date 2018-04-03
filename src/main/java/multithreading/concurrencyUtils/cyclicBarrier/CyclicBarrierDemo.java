package multithreading.concurrencyUtils.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by amit.k.mula on 12/3/17.
 */

class BarrierRunnable implements Runnable {

    CyclicBarrier cBarrier1;
    CyclicBarrier cBarrier2;

    public BarrierRunnable(CyclicBarrier cBarrier1, CyclicBarrier cBarrier2) {
        this.cBarrier1 = cBarrier1;
        this.cBarrier2 = cBarrier2;
    }

    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " is waiting at cyclic barrier 1");
            cBarrier1.await();

            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " is waiting at cyclic barrier 2");
            cBarrier2.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

class BarrierAction1 implements Runnable {
    public void run() {
        System.out.println("BarrierAction1 executed");
    }
}

class BarrierAction2 implements Runnable {
    public void run() {
        System.out.println("BarrierAction2 executed");
    }
}

public class CyclicBarrierDemo {

    public static void main(String args[]) throws BrokenBarrierException, InterruptedException {

        CyclicBarrier cyclicBarrier1 = new CyclicBarrier(2, new Thread(new BarrierAction1()));
        CyclicBarrier cyclicBarrier2 = new CyclicBarrier(2, new Thread(new BarrierAction2()));

        Thread barrierRunnerThread1 = new Thread(new BarrierRunnable(cyclicBarrier1, cyclicBarrier2), "Thread One");
        Thread barrierRunnerThread2 = new Thread(new BarrierRunnable(cyclicBarrier1, cyclicBarrier2), "Thread Two");

        barrierRunnerThread1.start();
        barrierRunnerThread2.start();
    }
}
