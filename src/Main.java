import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main implements Runnable {
    private int counterLimit;
    public Main(int counterLimit){
        this.counterLimit = counterLimit;
    }
    public static void main(String[] args) {
        for(int i =1; i<5; i++){
            Random random = new Random();
            new Thread(new Main(random.nextInt(1,20)), "Thread "+i).start();
        }
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println("Starting thread " + threadName);
        for(int i =1; i<counterLimit; i++){
            //With thread is only with milliseconds
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            //With timeUnit you can specify the unity
            //TimeUnit.SECONDS.sleep(1);

            System.out.println(threadName+" Counter: " + i + " / " + this.counterLimit);
        }
        System.out.println("Finishing thread " + threadName);
    }
}
