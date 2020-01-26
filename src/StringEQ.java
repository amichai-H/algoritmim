import java.lang.reflect.Array;
import java.util.Arrays;

public class StringEQ {
    public static String chack(String a ,String b){
        int[][] matrix = new int[a.length()][b.length()];
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
        for (int i =0; i<matrix.length;i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }


        StringBuilder temp = new StringBuilder();
        int i = a.length()-1, j =b.length()-1;
        int size = matrix[i][j];
        int count = size;
        while (i>=0&&j>=0|| count>0){
//            System.out.println(i+" "+j+" "+count+" " +temp);
            if (a.charAt(i)==b.charAt(j)){
                    temp.insert(0, a.charAt(i));
                    i--;
                    j--;
                    count--;

            }
            else if(j>0&&matrix[i][j]==matrix[i][j-1]){
                j--;
            }
            else {
                i--;
            }
        }
        return temp.toString();

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
        System.out.println(chack("xxkxkxkxx","kkkxkkkkkxkkkxk"));

    }
}
