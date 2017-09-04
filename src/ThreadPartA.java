import java.util.concurrent.Semaphore;


/**
 * Created by pc on 31 ago 2017.
 */
public class ThreadPartA extends Thread{

    private Matrix m;
    private int max;
    private boolean sym;


    public ThreadPartA(Matrix m, int max, boolean sym){
        this.m = m;
        this.max = max;
        this.sym = sym;
    }


    @Override
    public void run(){
        int cont = 0;
        int midRows = ( ( m.cols() - 1 ) / 2 ) + 1;


        for(int i = 1; i < midRows; i++){
            for(int j = 1; j < i ; j++){
                if( m.get(i,j) != m.get(j,i)) {
                    if (cont == max){
                        i = m.rows()+1;
                        j = m.cols()+1;
                    }else {
                        sym = false;
                        ++cont;
                    }
                }
            }
        }
        sym = true;
    }

}
