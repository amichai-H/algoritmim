import java.lang.reflect.Array;
import java.util.Arrays;

public class StringEQ {
    public static String chack(String a ,String b){
        int matrix[][] = new int[a.length()][b.length()];
        actionFirst(matrix,a,b);

        for (int i =1;i<a.length();i++){
            for (int j = 1; j<b.length();j++){
                if (a.charAt(i)==b.charAt(j)) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                }else {
                    matrix[i][j] = Math.max(matrix[i - 1][j],matrix[i][j-1]);

                }
            }
        }
        System.out.println(Arrays.toString(matrix[0]));
        System.out.println(Arrays.toString(matrix[1]));
        System.out.println(Arrays.toString(matrix[2]));
        System.out.println(Arrays.toString(matrix[3]));
        System.out.println(Arrays.toString(matrix[4]));
        System.out.println(Arrays.toString(matrix[5]));
        String temp ="";
        int i = a.length()-1, j =b.length()-1;
        while (i>=0&&j>=0){
            if(i==0&&j>0){
                if (a.charAt(i)==b.charAt(j))
                    temp =a.charAt(i)+temp;

            }
            else if (a.charAt(i)==b.charAt(j)) {
                temp = a.charAt(i) + temp;
                i--;
                j--;
            }
            else if(i>0&&j>0&&matrix[i-1][j]>matrix[i][j-1]){
                i--;
            }
            else {
                j--;
            }
            if (i==0||j==0){
                break;
            }
        }
        while (i>=0&&matrix[i][j]==0){
            i--;
        }
        System.out.println(i);
        return a.charAt(i)+temp;

    }

    private static void actionFirst(int[][] matrix, String a, String b) {
        boolean FLAG = false;
        for (int alfa = 0;alfa<a.length();alfa++){
            for (int beta = 0;beta<1;beta++){
                if (FLAG||a.charAt(alfa)==b.charAt(beta)){
                    matrix[alfa][beta] = 1;
                    FLAG = true;
                }
            }
        }
        FLAG = false;
        for (int beta = 0;beta<b.length();beta++){
            for (int alfa = 0;alfa<1;alfa++){
                if (FLAG||a.charAt(alfa)==b.charAt(beta)){
                    matrix[alfa][beta] = 1;
                    FLAG = true;
                }
            }
        }

    }
    public static void main(String[] args){
        System.out.println(chack("vaxcxxxxvxxsxdxxxmxnxxxjxkxxxxxtx","kakkcvkkkskdkxkkkkmkknjkkkkkt"));
    }
}
