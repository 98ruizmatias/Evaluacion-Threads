import com.sun.tools.classfile.Annotation;

import java.util.concurrent.Semaphore;


public class App {
    public static void main(String[]args) {


        /*Ejercico 1 y 2*/

        /*
        * A = 1
        * B = 2
        * C = 3
        *
        * AAABBC = 111223
        *
        * */

        int [] data = new int[12];
        Counter counter = new Counter(0);
        Semaphore x = new Semaphore(3);
        Semaphore y = new Semaphore(0);
        Semaphore z = new Semaphore(0);
        Semaphore A = new Semaphore(0);

        ThreadA tha = new ThreadA(data, 1 ,counter, x, y, z, A);
        ThreadB thb = new ThreadB(data, 2 ,counter, x, y, z, A);
        ThreadC thc = new ThreadC(data, 3 ,counter, x, y, z, A);


        tha.run();
        thb.run();
        thc.run();



        try{
            tha.join();
            thb.join();
            thc.join();
        } catch (Exception e){
            e.printStackTrace();
        }

        for (int i= 0; i < data.length; ++i){
            System.out.println(data[i]);
        }



    }
}
