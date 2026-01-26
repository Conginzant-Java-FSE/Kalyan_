import java.util.ArrayList;
import java.util.List;

class PrimeTask implements Runnable {

    int start;
    int end;

    PrimeTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    
    private boolean isPrime(int num) {
        if (num <= 1)
            return false;

        for (int i = 2; i < num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public void run() {
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                System.out.println(Thread.currentThread().getName() + " -> " + i);
            }
        }
    }
}

public class PrimeNumber {

    public static void main(String[] args) {

        int totalThreads = 10;
        int range = 1000;
        int numbersPerThread = range / totalThreads;

        List<Thread> threadList = new ArrayList<>();

        int start = 1;

        for (int i = 0; i < totalThreads; i++) {

            int end = start + numbersPerThread - 1;

            PrimeTask task = new PrimeTask(start, end);
            Thread thread = new Thread(task);

            thread.setName("Thread-" + (i + 1));
            thread.start();

            threadList.add(thread);

            start = end + 1;
        }

        
        for (Thread t : threadList) {
            try {
                t.join();
            } catch (InterruptedException ie) {
                System.out.println(ie.getMessage());
            }
        }

        System.out.println("All threads completed execution");
    }
}
