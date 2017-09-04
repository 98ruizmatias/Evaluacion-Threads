
public class ThreadPartB extends Thread{
    private Matrix m;
    private int max;
    private boolean sym;

    public ThreadPartB(Matrix m, int max, boolean sym){
        this.m = m;
        this.max = max;
        this.sym = sym;
    }


    @Override
    public void run(){
        int cont = 0;
        int midRows = ( ( m.cols() - 1 ) / 2 ) + 1;

        for(int i = midRows; i < m.rows(); i++){
            for(int j = 1; j < i;j++){
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
