/**
 * Created by pc on 31 ago 2017.
 */
public class Matrix {
    private int rows;
    private int cols;
    private double[][] data;

    public Matrix(int rows, int	cols){


        this.rows = rows;
        this.cols = cols;
        this.data = new double[rows][cols];

    }

    //Some methods

    public int rows(){
        return this.rows;
    }
    public int cols(){
        return this.cols;
    }

    public double get(int i, int j){
        return this.data[i][j];
    }

    public void set(int i, int j, double value){
        this.data[i][j] = value;
    }


    public Matrix(double[][]data){

        this(data.length, data[0].length);
        for (int i = 0; i < this.rows ;  i++) {
            for (int j = 0; j < this.cols; j++) {
                this.data[i][j] = data[i][j];
            }
        }

    }


    public Matrix(Matrix m){
        this.data = new double[rows][cols];
        for (int i = 0; i < m.rows() ; i++) {
            for (int j = 0; j < m.cols() ; j++) {
                m.set(i,j, this.data[i][j]);
            }
        }
    }



    public boolean symmetric(){
        for(int i = 1; i < this.rows(); i++){
            for(int j = 1; j < i;j++){
                if( this.get(i,j) != this.get(j,i)) {
                    return false;
                }
            }
        }
        return true;
    }


    public int getMid(){
        int n = this.cols() * this.rows();
        return ((n*(n+1))/2)-this.cols();
    }


}
