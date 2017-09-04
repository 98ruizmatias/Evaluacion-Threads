import java.util.concurrent.Semaphore;


public class ThreadB extends Thread {

    private int value;
    private int[] data;
    private Counter counter;
    private Semaphore x;
    private Semaphore y;
    private Semaphore z;
    private Semaphore A;

    public ThreadB(int[] data, int value, Counter counter, Semaphore x, Semaphore y, Semaphore z, Semaphore A){
        this.data = data;
        this.value = value;
        this.counter = counter;
        this.x = x;
        this.y = y;
        this.z = z;
        this.A = A;
    }

    @Override
    public void run()  {

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (this.counter.getValue() < data.length){

            try{
                this.y.acquire();
                this.y.acquire();
                this.y.acquire();
                this.A.acquire();
                this.A.acquire();
            } catch(Exception e){
                e.printStackTrace();
            }

            if (this.counter.getValue() >= data.length) {
                this.A.release();
                this.A.release();
                this.A.release();
                this.z.release();
            }

            this.data[this.counter.getValue()] = this.value;

            this.counter.inc();

            this.A.release();
            this.A.release();
            this.A.release();
            this.z.release();

        }

    }
}