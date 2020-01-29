import java.util.Stack;

public class BigRectangle {
    public static int solution(int[][] matrix){//O(n*m)
        if (matrix.length==0) return 0;
        int max=0;
        int[] help =new int[matrix[0].length];//all 0
        for (int i = 0; i<matrix.length;i++){
            for (int j = 0;j<help.length;j++){
                if (matrix[i][j]==1) help[j]=help[j]+1;
                else help[j] = 0;
            }
            max = Math.max(max,biggestAreaHistogram(help));
        }
        return max;
    }
    public static int biggestAreaHistogram(int[] arr){//O(n)
        Stack<Integer> myStack = new Stack<>();
        int top,i=0,area,maxArea=0,n=arr.length;
        while (i<n){
            if (myStack.isEmpty()||arr[myStack.peek()]<arr[i]){
                myStack.push(i);
                i++;
            }
            else {
                top = myStack.pop();
                if (myStack.isEmpty()){
                    area = arr[top]*i;
                }
                else {
                    area = arr[top]*(i - myStack.peek()-1);
                }
                maxArea = Math.max(area,maxArea);
            }

        }
        while (true){
            top = myStack.pop();
            if (myStack.isEmpty()){
                area = arr[top]*i;
                maxArea = Math.max(area,maxArea);
                break;
            }
            else {
                area = arr[top]*(i - myStack.peek()-1);
            }
            maxArea = Math.max(area,maxArea);

        }
        return maxArea;


    }

    public static void main(String[] args){
//        int[] a = {2,1,2,3,1};
//        System.out.println(biggestAreaHistogram(a));
        int[][] matrix ={{0,0,1,1,1},
                         {0,0,1,0,0},
                         {0,0,0,1,1},
                         {1,1,1,1,1},
                         {0,0,1,1,1}};

        System.out.println(solution(matrix));
    }
}
