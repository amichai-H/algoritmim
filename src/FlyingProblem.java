public class FlyingProblem {
    private class Node{
        double Here;
        double costUP;
        double costNEXT;
        public Node(double up,double next){
            this.costNEXT= next;
            this.costUP = up;
        }
    }

    private Node[][] myWay = new Node[5][5];

    private void preInit(){
        myWay[0][0] = new Node(2,7);
        myWay[0][1] = new Node(3,9);
        myWay[0][2] = new Node(3,4.6);
        myWay[0][3] = new Node(6,12);
        myWay[0][4] = new Node(8,21);

        myWay[1][0] = new Node(5,1);
        myWay[1][1] = new Node(78,5);
        myWay[1][2] = new Node(11,6);
        myWay[1][3] = new Node(4,3);
        myWay[1][4] = new Node(8,10);

        myWay[2][0] = new Node(9,3);
        myWay[2][1] = new Node(3,7);
        myWay[2][2] = new Node(4,8);
        myWay[2][3] = new Node(8,4);
        myWay[2][4] = new Node(2,1);

        myWay[3][0] = new Node(0,5);
        myWay[3][1] = new Node(1,0);
        myWay[3][2] = new Node(23,2);
        myWay[3][3] = new Node(11,4);
        myWay[3][4] = new Node(6,7);

        myWay[4][0] = new Node(14,2);
        myWay[4][1] = new Node(8,3);
        myWay[4][2] = new Node(5,7);
        myWay[4][3] = new Node(9,2);
        myWay[4][4] = new Node(8,9);

    }

    private void init() {
        myWay[0][0].Here = 0;
        for (int i = 1; i < myWay.length; i++) {
            myWay[i][0].Here = myWay[i - 1][0].costUP+myWay[i-1][0].Here;
            myWay[0][i].Here = myWay[0][i-1].costNEXT+myWay[0][i-1].Here;
        }
    }
    private void findMin(){
        for(int i = 1 ; i<myWay.length;i++){
            for (int j = 1; j<myWay[0].length;j++){
                myWay[i][j].Here = Math.min(myWay[i-1][j].Here + myWay[i-1][j].costUP,myWay[i][j-1].Here + myWay[i][j-1].costNEXT);
            }
        }
    }
    public static void main(String [] args){
        FlyingProblem  flyingProblem= new FlyingProblem();
        flyingProblem.preInit();
        flyingProblem.init();
        flyingProblem.findMin();
        System.out.println(flyingProblem.myWay[4][4].Here);

    }
}
