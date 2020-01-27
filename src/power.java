public class power {

    public static double power(double x, int n){
        double result = 1;
        while (n>0){
            if (n%2==1) result = result*x;
            x=x*x;
            n=n/2;
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(Math.pow(5.7,8));
        System.out.println(power(5.7,8));
    }
}
