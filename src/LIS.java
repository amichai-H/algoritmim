import java.util.Arrays;

import static java.util.Arrays.sort;

public class LIS {

    public static int[] solution(int[] arr){
        int[] temp = duplicateArr(arr);
        sort(temp);
        return lcs(arr,temp);
    }

    private static int[] lcs(int[] arr, int[] temp) {
        int[][] matrix = new int[arr.length][temp.length];
        init(matrix, arr, temp);
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < temp.length; j++) {
                if(arr[i]==temp[j]){
                    matrix[i][j]=matrix[i-1][j-1]+1;
                }
                else matrix[i][j] = Math.max(matrix[i - 1][j],matrix[i][j-1]);
            }
        }
        for (int i =0; i<matrix.length;i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        int i = arr.length-1,j = temp.length-1;
        int size = matrix[i][j];
        System.out.println(size);
        int[] ans = new int[size];
        int count = size-1;
        while (i>=0 && j>=0&& count>=0) {
            if (arr[i] == temp[j]){
                ans[count]=arr[i];
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
        return ans;



    }

    private static void init(int[][] matrix, int[] arr, int[] temp) {
        boolean flag = false;
        boolean glag = false;
        for (int j =0;j<temp.length;j++) {
            if (flag || arr[0] == temp[j]) {
                flag = true;
                matrix[0][j] = 1;
            }
            if (glag||temp[0]==arr[j]){
                glag = true;
                matrix[j][0] = 1;
            }
        }
    }

    private static int[] duplicateArr(int[] arr) {
        int[] ans = new int[arr.length];
        for (int i = 0; i<arr.length;i++){
            ans[i] = arr[i];
        }
        return ans;
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,1,5,6,7,8};
        System.out.println(Arrays.toString(solution(arr)));;
    }
}
