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
//
//        int [] data = new int[12];
//        Counter counter = new Counter(0);
//        Semaphore x = new Semaphore(3);
//        Semaphore y = new Semaphore(0);
//        Semaphore z = new Semaphore(0);
//        Semaphore A = new Semaphore(0);
//
//        ThreadA tha = new ThreadA(data, 1 ,counter, x, y, z, A);
//        ThreadB thb = new ThreadB(data, 2 ,counter, x, y, z, A);
//        ThreadC thc = new ThreadC(data, 3 ,counter, x, y, z, A);
//
//
//        tha.run();
//        thb.run();
//        thc.run();
//
//
//
//        try{
//            tha.join();
//            thb.join();
//            thc.join();
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//
//        for (int i= 0; i < data.length; ++i){
//            System.out.println(data[i]);
//        }


        /*Ejercicio 3*/

//        int size = 10;
//        int [] data = new int[size];
//        Counter counter = new Counter(0);
//        Semaphore x = new Semaphore(3);
//
//        ThreadPar tp = new ThreadPar(size, data,counter,x);
//        ThreadImpar ti = new ThreadImpar(size, data,counter,x);
//
//        //tp.start();
//        ti.start();
//
//        try{
//            //tp.join();
//            ti.join();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//        for (int i= 0; i < data.length; ++i){
//            System.out.println(data[i]);
//        }




        /*Ejercicio 4*/

        Matrix matrix = new Matrix(3,3);

        boolean thA = true;
        boolean thB = true;

        ThreadPartA ta = new ThreadPartA(matrix,matrix.getMid() ,thA);
        ThreadPartB tb = new ThreadPartB(matrix, matrix.getMid(), thB);

        for (int i = 0; i < matrix.rows() ;  i++) {
            for (int j = 0; j < matrix.cols(); j++) {
                matrix.set(i,j,1);
            }
        }

        ta.start();
        tb.start();

        try {
            ta.join();
            tb.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        matrix.set(matrix.cols()-1, matrix.rows()-1, 0);
        matrix.set(matrix.cols()-2, matrix.rows()-1, 0);


        System.out.println(thA);
        System.out.println(thB);


    }
}
