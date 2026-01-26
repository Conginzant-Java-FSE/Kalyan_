import java.util.*;

public class MatrixMultiThread{
    public static void main(String[] args){

        int [][] matrix = {
            {1,2,3,4,5,6},
            {7,8,9,10,11,12},
            {13,14,15,16,17,18},
            {19,20,21,22,23,24},
            {25,26,27,28,29,30},
            {31,32,33,34,35,36}
        };

        int[] result = new int[6];

        List<Thread> threadList = new ArrayList<>();

        for (int i = 0; i < 6; i++){
            MatrixCalculator task = new MatrixCalculator(matrix,i,result);
            Thread th = new Thread(task);
            threadList.add(th);
            th.start();
        }
        for(Thread t : threadList) {
            try{
                t.join();
            } catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }

        for(int i = 0; i < result.length; i++){
            System.out.println(result[i]);
        }
    }
}
 
class MatrixCalculator implements Runnable{

    int[][] matrix;
    int rowIndex;
    int[] result;

    MatrixCalculator(int[][] matrix, int rowIndex, int[] result){
        this.matrix = matrix;
        this.rowIndex = rowIndex;
        this.result = result;
    }
    public void run(){
        int sum = 0;
        for(int j = 0; j < matrix[rowIndex].length;j++){
            sum += matrix[rowIndex][j];
        }
        result[rowIndex] = sum;
    }

}
