import java.util.concurrent.ExecutionException;
import java.util.concurrent.Semaphore;


public class ThreadA extends Thread {

    private int value;
    private int[] data;
    private Counter counter;
    private Semaphore x;
    private Semaphore y;
    private Semaphore z;
    private Semaphore A;

    public ThreadA(int[] data, int value, Counter counter, Semaphore x, Semaphore y, Semaphore z, Semaphore A){
        this.data = data;
        this.value = value;
        this.counter = counter;
        this.x = x;
        this.y = y;
        this.z = z;
        this.A = A;
    }


    @Override
    public void run()   {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while( this.counter.getValue() < data.length ){

            try {

                this.x.acquire();

            } catch (Exception e){
                e.printStackTrace();
            }

            if (this.counter.getValue() >= data.length) {
                this.x.release();
            }

            this.data[this.counter.getValue()] = this.value;

            this.counter.inc();

            this.x.release();

        }
    }
}
