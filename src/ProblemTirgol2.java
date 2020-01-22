public class ProblemTirgol2 {
    static int  number = 0;
    static int n =1000;
        static int[] findMaxAndMin(int[] arr){
            int max = arr[0];
            int min = arr[0];
            for (int i =1; i < arr.length;i++){
                if (arr[i]<min){
                    min = arr[i];
                    number++;
                }
                else if (arr[i]>max){
                    max = arr[i];
                    number = number+2;
                }
                else {
                    number=number+2;
                }
            }
            return new int[]{min,max};
        }

        static int[] randomArr(){
            int [] arr = new int[n];
            for (int i = 0 ; i<arr.length;i++){
                arr[i] = (int) (Math.random()*100000);
            }
            return arr;
        }

        static void statistik(){
            double num = 1000.0;
            for (int i = 0; i<num;i++){
                findMaxAndMin(randomArr());
            }
            System.out.println((number/num)/n);
        }

        public static void main(String[]args){
            statistik();
        }

        static int[] algo3(int[] arr){
            int min =0;
            int max =0;
            if (arr[0]<arr[1]) {
                max = arr[0];
                min = arr[1];
            }
            else {
                min = arr[1];
                max = arr[2];
            }
            for (int i = 0;i<arr.length;i++){

            }
                return null;
        }
}
