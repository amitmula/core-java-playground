package multithreading.concurrencyUtils.forkJoinPool;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

class MyBigRecursiveTask extends RecursiveTask<Long> {

    private long workLoad;

    public MyBigRecursiveTask(long workLoad) {
        this.workLoad = workLoad;
    }

    @Override
    protected Long compute() {
        List<MyBigRecursiveTask> tasks = new ArrayList<MyBigRecursiveTask>();

        if(this.workLoad > 4) {
            tasks.addAll(createSubTasks());

            for(MyBigRecursiveTask task : tasks) {
                task.fork();
            }

            long result = 0;
            for(MyBigRecursiveTask task : tasks) {
                result += task.join();
            }
            return result;

        } else {
            System.out.println("Taking up this task myself. Workload : " + this.workLoad);
            return this.workLoad * 3;
        }
    }

    private List<MyBigRecursiveTask> createSubTasks() {
        List<MyBigRecursiveTask> subTasks = new ArrayList<MyBigRecursiveTask>();
        subTasks.add(new MyBigRecursiveTask(this.workLoad/2));
        subTasks.add(new MyBigRecursiveTask(this.workLoad/2));
        return subTasks;
    }
}

class MyBigRecursiveAction extends RecursiveAction {

    private long workLoad = 0;
    public MyBigRecursiveAction(long workLoad) {
        this.workLoad = workLoad;
    }

    @Override
    protected void compute() {
        List<MyBigRecursiveAction> actions = new ArrayList<MyBigRecursiveAction>();
        if(this.workLoad > 6) {
            System.out.println("Splitting workLoad : " + this.workLoad + " into sub actions.");
            actions.addAll(createSubActions());
            for(MyBigRecursiveAction task : actions) {
                task.fork();
            }
        } else {
            System.out.println("Taking up this action myself. WorkLoad : " + this.workLoad);
        }
    }

    private List<MyBigRecursiveAction> createSubActions() {
        List<MyBigRecursiveAction> subTasks = new ArrayList<MyBigRecursiveAction>();
        subTasks.add(new MyBigRecursiveAction(this.workLoad/2));
        subTasks.add(new MyBigRecursiveAction(this.workLoad/2));
        return subTasks;
    }
}

public class ForkJoinPoolDemo {
    public static void main(String args[]) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(4);

        System.out.println("Submitting a RecursiveAction to forkjoin pool");
        forkJoinPool.invoke(new MyBigRecursiveAction(24));
        if(forkJoinPool.awaitQuiescence(2, TimeUnit.SECONDS))
            System.out.println("RecursiveAction executed successfully.");


        System.out.println("\nSubmitting a RecursiveTask to forkjoin pool");
        Long result = (Long) forkJoinPool.invoke(new MyBigRecursiveTask(64));
        System.out.println("Merge result : " + result);
    }
}
