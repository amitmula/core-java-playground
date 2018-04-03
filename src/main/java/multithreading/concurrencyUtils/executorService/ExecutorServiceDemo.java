package multithreading.concurrencyUtils.executorService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.*;

/**
 * Created by amit.k.mula on 14/3/17.
 */

class SingleThreadExecutorTask implements Callable<String> {
    public String call() throws Exception {
        return UUID.randomUUID().toString();
    }
}

class SingleThreadExecutor {
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    public Future<String> execute() {
        Future<String> stringFuture = executorService.submit(new SingleThreadExecutorTask());
        executorService.shutdown();
        return stringFuture;
    }
}

class FixedThreadPoolExecutorTask implements Callable<String> {
    String taskName;

    public FixedThreadPoolExecutorTask(String taskName) {
        this.taskName = taskName;
    }

    public String call() throws Exception {
        return this.taskName +  " is being handled by thread : "  + Thread.currentThread().getName();
    }
}

class FixedThreadPoolExecutor {
    ExecutorService executorService = Executors.newFixedThreadPool(10);
    public List<Future<String>> execute() {
        List<FixedThreadPoolExecutorTask> tasksList = new ArrayList<FixedThreadPoolExecutorTask>();
        tasksList.add(new FixedThreadPoolExecutorTask("Task1"));
        tasksList.add(new FixedThreadPoolExecutorTask("Task2"));
        tasksList.add(new FixedThreadPoolExecutorTask("Task3"));
        tasksList.add(new FixedThreadPoolExecutorTask("Task4"));
        tasksList.add(new FixedThreadPoolExecutorTask("Task5"));
        tasksList.add(new FixedThreadPoolExecutorTask("Task6"));
        tasksList.add(new FixedThreadPoolExecutorTask("Task7"));
        tasksList.add(new FixedThreadPoolExecutorTask("Task8"));
        tasksList.add(new FixedThreadPoolExecutorTask("Task9"));
        tasksList.add(new FixedThreadPoolExecutorTask("Task10"));
        tasksList.add(new FixedThreadPoolExecutorTask("Task11"));
        tasksList.add(new FixedThreadPoolExecutorTask("Task12"));
        tasksList.add(new FixedThreadPoolExecutorTask("Task13"));
        List<Future<String>> taskFutures = null;
        try {
            taskFutures = executorService.invokeAll(tasksList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        return taskFutures;
    }
}

public class ExecutorServiceDemo {
    public static void main(String args[]) {

        SingleThreadExecutor singleThreadExecutor = new SingleThreadExecutor();
        Future<String> stringFuture = singleThreadExecutor.execute();
        try {
            System.out.println("Future returned : " + stringFuture.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        FixedThreadPoolExecutor fixedThreadPoolExecutor = new FixedThreadPoolExecutor();
        List<Future<String>> futureList = fixedThreadPoolExecutor.execute();
        for(Future<String> future : futureList) {
            try {
                System.out.println("Future returned  : " + future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
