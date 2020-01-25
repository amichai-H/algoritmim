public class PizzaProblem {
   public static void main(String [] args){
       int x = 9;
       double p = howMuchPicec(x);
       System.out.println(p);
   }

    private static double howMuchPicec(double x) {
       double split = 2;
       double beniEate;
       double eliEate;
       double maxOfBeni = 0;
       double maxOfSplit = 0;
       while (true){
            if ((x+1)%split==0&&x+1!=split)
                split++;
            beniEate = 0;
            eliEate = 0;
            while (beniEate + eliEate <1){
                eliEate = eliEate+1.0/split;
                double left  = 1-eliEate-beniEate;
                beniEate = Math.min(left,x/split) + beniEate;
            }
            if (maxOfBeni<beniEate) {
                maxOfBeni = beniEate;
                maxOfSplit = split;
            }
            else return
                    maxOfSplit;
            split++;
       }
    }
}
