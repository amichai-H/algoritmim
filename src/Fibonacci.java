public class Fibonacci {

    private static int[][] matricsMult(int[][] mat1,int[][] mat2){
        int[][] ans =  new int[mat1.length][mat2[0].length];
        for (int row = 0; row <mat1.length;row++){
            for (int col=0;col<mat2[row].length;col++){
                ans[row][col] = multiplyMatricesCell(mat1, mat2, row, col);
            }
        }
        return ans;
    }

    private static int multiplyMatricesCell(int[][] mat1, int[][] mat2, int row, int col) {
        int cell = 0;
        for (int i = 0; i < mat2.length; i++) {
            cell += mat1[row][i] * mat2[i][col];
        }
        return cell;
    }


    public static double solution(int n){
        if (n==0) return 0;
        if (n==1||n==2) return 1;
        int[][] fibBase = {{1,1},{1,0}};
        int[][] result = {{1,1},{1,0}};
        n=n-2;//importent
        while (n > 0) {

            if (n%2==1) result = matricsMult(result,fibBase);
            fibBase = matricsMult(fibBase,fibBase);
            n=n/2;
        }
        return result[0][0];

    }
    public static void main(String[] args){
        System.out.println(solution(8));
    }


}
