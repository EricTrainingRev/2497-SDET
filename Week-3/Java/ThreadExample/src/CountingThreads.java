
public class CountingThreads {

    public static void main(String[] args) {
        //A runnable is a class/method (actually a functional interface carrying a method implementation here)
        //that is used to encapsulate executable statements.
        //The purpose is to pass that execution to another thread.
        Runnable counter = () -> {
            String name = Thread.currentThread().getName();
            for (int i = 1; i <= 20; i++) {
                System.out.println(name + ": " + i);
            }
        };

        //Here we create two new Thread objects, and pass the runnables to them, along with a name to
        //identify each one
        Thread threadA = new Thread(counter, "Thread-A");
        Thread threadB = new Thread(counter, "Thread-B");

        //calling start on a thread spins up a new thread and starts executing
        //calling run() just starts the execution
        //calling start() spins up a new thread then calls run() in that thread
        threadA.start();
        threadB.start();
    }
}