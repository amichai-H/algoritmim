public class LoopByArr {
    private int[] arr;
    int[] pepole;

    public LoopByArr(int size,int amountOfId){
        arr = new int[size];
        pepole = new int[amountOfId];
        for (int i=0; i<pepole.length;i++){
            pepole[i] = 0;
        }
    }

    public void addSine(int sine,int id){
        arr[Math.floorMod(pepole[id], arr.length)] = sine;
    }

    public int getSine(int id){
        if (id<pepole.length) {
            return arr[Math.floorMod(pepole[id],arr.length)];
        }
        else throw new RuntimeException("doseNotExist");
    }

    public void move(int id, int steps){
        pepole[id] = pepole[id] + steps;
    }

    public void problem(){
        arr[3] = 1000;
        arr[7] = 1000;
        arr[15] = 1000;
    }


}
