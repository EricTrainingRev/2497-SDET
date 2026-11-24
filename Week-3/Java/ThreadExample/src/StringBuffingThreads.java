public class StringBuffingThreads {
    public static void main(String[] args) throws InterruptedException {
        StringBuffer log = new StringBuffer();

        Runnable counter = () -> {
            String name = Thread.currentThread().getName();
            for (int i = 1; i <= 20; i++) {
//                System.out.println(name + ": " + i);
                log.append(name + ": " + i + "\n");
            }
        };

        Thread threadA = new Thread(counter, "Thread-A");
        Thread threadB = new Thread(counter, "Thread-B");

        threadA.start();
        threadB.start();

        threadA.join();
        threadB.join();

        System.out.println("\n--- Shared StringBuffer contents ---");
        System.out.print(log);
    }
}
