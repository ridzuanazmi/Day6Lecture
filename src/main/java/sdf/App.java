package sdf;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        // Thread thread1 = new Thread(new Runnable() {

        //     @Override
        //     public void run() {
        //         for (int i = 0; i < 5; i++) {
        //             System.out.println(Thread.currentThread().getName() + "\tRunnable ..." + i);
        //         }

        //     }

        // }); // end of thread1

        // thread1.start();

        MyRunnableImplementation mRI = new MyRunnableImplementation("T1");
        MyRunnableImplementation mRI2 = new MyRunnableImplementation("T2");
        MyRunnableImplementation mRI3 = new MyRunnableImplementation("T3");
        // MyRunnableImplementation mRI4 = new MyRunnableImplementation("T4");
        // MyRunnableImplementation mRI5 = new MyRunnableImplementation("T5");

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

        // ExecutorService executorService = Executors.newCachedThreadPool();
        // executorService.execute(mRI);
        // executorService.execute(mRI2);
        // executorService.execute(mRI3);
        // executorService.shutdown();

        // Start of lambda expression
        MyRunnableInterface<Integer> addOperation = (a, b) -> {
            return a + b;
        };
        System.out.println("addOperation: " + 
        addOperation.process(1, 2));

        MyRunnableInterface<Integer> multiplyOperation = (c, d) -> {
            return c * d;
        };
        System.out.println("multiplyOperation = " + 
        multiplyOperation.process(2, 3));

        MyRunnableInterface<Integer> subtractionOperation = (c, d) -> {
            return c * d;
        };
        System.out.println("subtrationOperation = " + 
        subtractionOperation.process(5, 2));

        MyRunnableInterface<String> concatenateString = (a, b) -> {
            return a + b;
        };
        System.out.println("concatenateOperation = " + 
        concatenateString.process("I am ", "the strongest"));

        MyMessageInterface printString = a -> {
            System.out.println(a);
        };
        printString.printMessage("Hello and welcome to Lambda expression");

        //List of employees
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee(1, "Adam", 
        "Turner", 10000));
        employees.add(new Employee(1, "Gilbert", 
        "Chuck", 20000));
        employees.add(new Employee(1, "Mary", 
        "Tan", 30000));
        employees.add(new Employee(1, "Larry", 
        "Daniels", 40000));
        employees.add(new Employee(1, "Diana", 
        "Ecclestone", 50000));

        // using labda expression to print the array list, employees
        employees.forEach(emp -> {
            System.out.println(emp);
        });
        System.out.println("---------------------------------------------------------------------");

        // filter employees by last name contains "ne"
        // List<Employee> filteredEmployees = employees.stream().filter(emp -> 
        // emp.getLastName().contains("ne")).collect(Collectors.toList());
        // filteredEmployees.forEach(emp -> System.out.println(emp));

        // employees.sort(Comparator.comparing(e -> e.getFirstName()));
        // employees.sort(Comparator.comparing(Employee::getFirstName));
        Comparator<Employee> compare= Comparator.comparing(e -> e.getFirstName());
        employees.sort(compare.reversed());

        // employees.forEach(emp -> {
        //     System.out.println(emp);
        // });

        Comparator<Employee> groupByComparator = Comparator.comparing
        (Employee::getFirstName).thenComparing(Employee::getLastName);
        employees.sort(groupByComparator);
        employees.forEach(emp -> {
            System.out.println(emp);
        });

    }
}
