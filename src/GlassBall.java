public class GlassBall {
    static int[] building = {0,2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,42,44,46,48,50,52,54,56,58,60,62,100};


    public static int sulotion(int amountOfBalls,int strogOfTheBall, int index, int end){
        if (amountOfBalls==1) return regularSearch(strogOfTheBall,index,end);
        if (amountOfBalls>=logBase2(end-index)){
            return binarySearch(strogOfTheBall,index,end);
        }
        else {
            int k  = caculateTrengel(index,end);
            boolean brake = findBySplit(k+index,strogOfTheBall);
            if (!brake){
                index =index+ k;
                //System.out.println(index);
                return sulotion(amountOfBalls,strogOfTheBall,index,end);
            }
            else{
                amountOfBalls--;
                end = index+ k;
                return sulotion(amountOfBalls,strogOfTheBall,index,end);

            }

        }

    }

    private static boolean findBySplit(int k, int strogOfTheBall) {

        return strogOfTheBall<building[k];
    }

    private static int caculateTrengel(int index,int end) {
        int left = end - index;
        int sum  = 1;
        for (int i=2;true;i++){
            if (left<sum+i) return i-1;
            else sum=sum+i;
        }
    }

    private static int regularSearch(int n, int start, int end) {
        for (int i = start; i<end;i++){
            if (n>=building[i]&&n<building[i+1]) return i+1;
        }
        return -1;
    }

    private static int binarySearch(int n, int start,int end) {
        if (end-start==1) {
            if (n > building[start]) return end;
            return start;
        }
       while (end-start>1) {
           if (n == building[start]) return start;
           if (n == building[end]) return end;
           int mid = (start+end)/2;
           if (n==building[mid]) return mid;
           if (n>building[mid]) start=mid;
           else end = mid;
       }
       return end;
    }

    private static double logBase2(int n) {
        return Math.log(n)/Math.log(2);
    }

    public static void main(String [] args){
        System.out.println(sulotion(4,100,0,building.length-1));
    }
}
