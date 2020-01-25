public class NumGame {
    Player playerA = new Player();
    Player playerB = new Player();
    int[] boardGame = {1,10,10,6,70,8};// if not odd Player A not always win

    public void playerATurn(){
         boardGame = playerA.winingAlgoritem(boardGame);
    }
    public void playerBTurn(){
         boardGame = playerB.winingAlgoritem(boardGame);
    }
    public boolean gameIsRunning(){
        return boardGame.length > 0;
    }
    public String whoWin(){
        if (playerA.score==playerB.score)
            return "same score";
        if (playerA.score >playerB.score){
            return "playerA won in " + (playerA.score - playerB.score);
        }
        else return "playerB won in " + (playerB.score - playerA.score);
    }

     public class Player {
        private int score;

        public Player(){
            score=0;
        }
        public int[] takeFromTOP(int[] arr){
            score = score+arr[arr.length-1];
            int[] tempArr = new int[arr.length-1];
            for (int i=0;i<tempArr.length;i++){
                tempArr[i] = arr[i];
            }
            return tempArr;
        }
        public int[] takeFromBottom(int[] arr){
            score = score+arr[0];
            int[] tempArr = new int[arr.length-1];
            for (int i=0;i<tempArr.length;i++){
                tempArr[i] = arr[i+1];
            }
            return tempArr;
        }
        public int[] gridiAlgo(int[] arr){
            if (arr[0]>arr[arr.length-1]){
                return takeFromBottom(arr);
            }
            else return takeFromTOP(arr);
        }
        public int[] winingAlgoritem(int[] arr){
            int sumOfOdd=0;
            int sumOfEven=0;
            for (int i = 0 ;(i*2)<arr.length;i++){
                sumOfOdd = arr[i*2]+sumOfOdd;
                if ((i*2+1)<arr.length){
                    sumOfEven = sumOfEven+arr[i*2+1];
                }
            }
            if (sumOfEven > sumOfOdd && arr.length%2==1) {
                return takeFromTOP(arr);
            }
            else if (sumOfOdd > sumOfEven && arr.length % 2 == 0) {
                return takeFromBottom(arr);
            }
            else
               return gridiAlgo(arr);
        }
    }

    public static void main(String[] args){
        NumGame game = new NumGame();
        boolean turn = true;
        while (game.gameIsRunning()){
            if (turn){
                game.playerATurn();
                turn = false;
            }else {
                game.playerBTurn();
                turn = true;
            }

        }
        System.out.println(game.whoWin());


    }
}
