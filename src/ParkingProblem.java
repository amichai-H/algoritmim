public class ParkingProblem {
    static int v = 1000;
    static int vv =2000;

    static LoopByArr loopByArr = new LoopByArr(20,2);

    public static int sulotion(){
        loopByArr.addSine(v,0);
        int sum = 0;
        boolean first = true;
        int inside = 2;
        while (true) {
            while (!((loopByArr.getSine(0) == v))||first){
                first = false;
                sum++;
                System.out.println(sum);
                loopByArr.move(0, 1);
            }
            loopByArr.addSine(v, 0);
            loopByArr.move(0, (-1 * sum));
            System.out.println("***********"+loopByArr.getSine(0)+"*************"+inside*v);
            if (loopByArr.getSine(0) == inside*v ) {
                return sum;
            }
            inside++;
            first = true;
        }

    }

    public static int sulotion2(){
        Parking parking = new Parking(78787,6767);
        boolean finish = false;
        int currentPosintion = 1;
        int carpass = 0;
        int sine = 1;
        parking.addSine(sine);
        parking.next();
        currentPosintion++;
        while (!finish){
            if (parking.getSine()==sine){
                sine++;
                parking.deleteSine();
                parking.addSine(sine);
                int dbug  = parking.getHere();
                for (int i = currentPosintion;i>1;i--){
                    parking.previes();
                }
                if (parking.getSine()==sine){
                    return currentPosintion-1;
                }
                else {
                    sine--;
                    for (int i=1; i<currentPosintion;i++){
                        parking.next();
                    }
                }


            }
            parking.next();
            currentPosintion++;
        }

        return 0;
    }

    public static int arnavAndTzav(){
        Parking tzav = new Parking(40,0);
        Parking arnav = new Parking(40,0);
        tzav.next();
        tzav.next();
        arnav.next();
        arnav.next();
        arnav.next();
        int move = 1;
        while (true){
            if (tzav.getHere()==arnav.getHere()){
                System.out.println("arnav: "+ arnav.getRound()+ " steps: " +arnav.getSteps());
                System.out.println("tzav: "+ tzav.getRound()+" steps: "+ tzav.getSteps());
                return move;
            }
            arnav.next();
            arnav.next();
            arnav.next();
            tzav.next();
            tzav.next();
            move++;

        }

    }




    public static void main(String []args){
//        loopByArr.problem();
//        System.out.println(Math.floorMod(10,20));
//        System.out.println(sulotion());
//        System.out.println(sulotion2());
        System.out.println(arnavAndTzav());
    }





}
