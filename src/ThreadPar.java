import java.util.concurrent.Semaphore;

public class ThreadPar extends Thread {

    private int size;
    private int[] data;
    private Counter counter;
    private Semaphore x;


    public ThreadPar(int size, int[] data, Counter counter, Semaphore x){
        this.size = size;
        this.data = data;
        this.counter = counter;
        this.x = x;
    }

    @Override

    public void run(){
        while (this.counter.getValue() < this.size){

            try{
                this.x.acquire();
            } catch(Exception e){
                e.printStackTrace();
            }

            this.data[this.counter.getValue()] = this.counter.getValue() * 2;

            this.counter.inc();

            this.x.release();
        }

    }

}


