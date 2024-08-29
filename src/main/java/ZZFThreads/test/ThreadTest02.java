package ZZFThreads.test;

class ThreadExampleRunnable2 implements Runnable {
    private final String c;
    private final int sleepTime;
    public ThreadExampleRunnable2(String c, int sleepTime) {
        this.c = c;
        this.sleepTime = sleepTime;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 500; i++) {
            System.out.print(c);
            if(i % 100 == 0){
                System.out.println();
            }
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

//Daemon x User
// Java encerra o programa quando as threads do tipo User são encerradas.
public class ThreadTest02 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new ThreadExampleRunnable2("KA", 200));
        Thread t2 = new Thread(new ThreadExampleRunnable2("ME", 195));
        Thread t3 = new Thread(new ThreadExampleRunnable2("HA", 425));
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.start();
//        t1.join();
        t2.start();
        t3.start();

    }
}
