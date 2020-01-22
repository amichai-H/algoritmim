public class Parking {
    private int[] places;
    private int size = 0;
    private int here = 0;

    public Parking(int size, int level){
        places = new int[size];
        this.size = size;
        //places[level] = 1;



    }
    public void addSine(int sine){
        places[Math.floorMod(here,size)] = sine;
    }
    public void deleteSine(){
        places[Math.floorMod(here,size)] = 0;
    }
    public int getSine(){
        return places[Math.floorMod(here,size)];
    }
    public void next(){
        here ++;
    }
    public void previes(){
        here--;
    }

    public int getHere() {
        return Math.floorMod(here,size);
    }
    public int getRound(){
        return here/size;
    }
    public int getSteps(){
        return here;
    }
}
