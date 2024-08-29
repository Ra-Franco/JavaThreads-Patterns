package ZZFThreads.test;

public class DeadlockTest01 {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();
        Runnable r1 = () -> {
            synchronized (o1) {
                System.out.println("Thread 1: Segurando lock 1");
                System.out.println("Thread 1: Esperando lock 2");
                synchronized (o2) {
                    System.out.println("Thread 1: Segurando lock 2");
                }

            }
        };
        Runnable r2 = () -> {
            synchronized (o1) {
                System.out.println("Thread 2: Segurando lock 2");
                System.out.println("Thread 2: Esperando lock 1");
                synchronized (o2) {
                    System.out.println("Thread 2: Segurando lock 1");
                }
            }
        };
        new Thread(r1).start();
        new Thread(r2).start();
    }
}
