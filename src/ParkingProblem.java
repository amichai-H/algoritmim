public class ParkingProblem {
    static int v = 1000;
    static int vv =2000;

    static LoopByArr loopByArr = new LoopByArr(20,2);

    public static int sulotion(){
        loopByArr.addSine(v,0);
        int sum = 0;
        boolean first = true;
        while (true) {
            while (!((loopByArr.getSine(0) == v))||first){
                first = false;
                sum++;
                loopByArr.move(0, 1);
            }
            loopByArr.addSine(vv, 0);
            loopByArr.move(0, (-1 * sum));
            if (loopByArr.getSine(0) == vv) {
                return sum;
            }
        }

    }



    public static void main(String []args){
        System.out.println(Math.floorMod(10,20));
        System.out.println(sulotion());
    }




}
