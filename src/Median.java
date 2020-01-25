import java.util.Arrays;

public class Median {
    int[] A ={20,30,32,45,67,100};
    int[] B ={12,22,25,70,102,103};

    public int[] solution(){
        int i = 0;
        int j = B.length-1;
        int[] ans =new int[A.length];
        while (j>=0){
            ans[i] = Math.max(A[i],B[j]);
            i++;
            j--;
        }
        return ans;

    }
    public static void main(String [] args){
        Median median = new Median();
        System.out.println(Arrays.toString(median.solution()));
    }
}
