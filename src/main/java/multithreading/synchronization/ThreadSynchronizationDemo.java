package multithreading.synchronization;

class EvenOddPrinter extends Thread{
    Integer counter;
    public EvenOddPrinter(Integer counter) {
        this.counter = counter;
    }
    public void run() {
        while(true) {
            synchronized (counter) {
                try {
                    Thread.sleep(1000);
                    counter++;
                    System.out.println(Thread.currentThread().getName() + " - " + counter);
                    if(counter % 2 == 0 )
                        wait();
                    else
                        notify();
                } catch(InterruptedException e) {}
            }
        }
    }
}

public class ThreadSynchronizationDemo {

    public static void main(String args[]) throws InterruptedException {

        //Todo : Write this even/odd printing with separate threads
        Integer counter = -1;
        Thread oddPrinter = new EvenOddPrinter(counter);
        oddPrinter.setName("oddPrinterThread");
        Thread evenPrinter = new EvenOddPrinter(counter);
        evenPrinter.setName("evenPrinterThread");
        evenPrinter.start();
        Thread.sleep(20);
        oddPrinter.start();

        /*ArrayList<String> listString = new ArrayList<String>();
        listString.add("aaa");
        listString.add("aab");
        listString.add("aac");
        listString.add("aad");
        listString.add("aae");
        Collection<String> strings = Collections.unmodifiableCollection(listString);
        Iterator<String> iterator = strings.iterator();
        while(iterator.hasNext()) {
            String val = iterator.next();
            if(val.equals("aab")) iterator.remove();
        }*/

        /*ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(thread1);
        executorService.execute(thread2);
        executorService.execute(thread3);

        executorService.shutdown();*/

        /*
        //Thread join example
        Thread thread1 = new Thread(new MyThread("thread1"));
        Thread thread2 = new Thread(new MyThread("thread2"));
        Thread thread3 = new Thread(new MyThread("thread3"));

        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread3.start();*/
    }
}
