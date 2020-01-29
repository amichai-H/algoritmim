import java.util.Arrays;

public class BigSquare {

    public static int solution(int[][] matrix){
        int[][] help = new int[matrix.length][matrix[0].length];
        int max = 0;
        init(help,matrix);
        for (int i = 1 ; i<matrix.length;i++){
            for (int j = 1; j<matrix[i].length;j++){
                if (matrix[i][j]==1){
                    help[i][j] = Math.min(Math.min(help[i-1][j-1],help[i][j-1]),help[i-1][j])+1;
                }
                else help[i][j]=0;
                max = Math.max(max,help[i][j]);
            }
        }
        return max;

    }

    private static void init(int[][] help, int[][] matrix) {
        for (int i = 0 ; i<matrix.length;i++){
            help[i][0] = matrix[i][0];
            help[0][i] = matrix[0][i];
        }
    }
    public static void main(String [] args){
        int[][] matrix ={{1,0,1,1,1},
                         {1,1,1,0,1},
                         {1,1,1,1,0},
                         {1,1,1,1,0}};

        System.out.println(solution(matrix));

    }
}
