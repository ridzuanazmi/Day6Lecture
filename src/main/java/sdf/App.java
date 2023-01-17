package sdf;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Every thread must have a runnable
     */
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() + "\tRunnable ..." + i);
                }
                
            }
            
        }); // end of thread1

        // thread1.start();

        MyRunnableImplementation mRI = new MyRunnableImplementation("T1");
        MyRunnableImplementation mRI2 = new MyRunnableImplementation("T2");
        MyRunnableImplementation mRI3 = new MyRunnableImplementation("T3");
        MyRunnableImplementation mRI4 = new MyRunnableImplementation("T4");
        MyRunnableImplementation mRI5 = new MyRunnableImplementation("T5");

        // Thread thread2 = new Thread(mRI);
        // thread2.start();

        // Thread thread3 = new Thread(mRI);
        // thread3.start();

        // need executor servcice to run a threadpool.
        // ExecutorService executorService = Executors.newSingleThreadExecutor();
        // executorService.execute(mRI);
        // executorService.execute(mRI2);
        // executorService.shutdown();        
        
        // ExecutorService executorService = Executors.newFixedThreadPool(3);
        // executorService.execute(mRI);
        // executorService.execute(mRI2);
        // executorService.execute(mRI3);
        // executorService.execute(mRI4);
        // executorService.execute(mRI5);
        // executorService.shutdown();

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(mRI);
        executorService.execute(mRI2);
        executorService.execute(mRI3);
    }
}
