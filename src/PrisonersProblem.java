public class PrisonersProblem {
    public static boolean[] prisonesr;
    public static boolean lamp = true;

    public static void init(int n){
        prisonesr = new boolean[n];
        for (int i = 0; i < prisonesr.length;i++){
            prisonesr[i] = false;
        }
    }

    public static int sulotion(){
        int n = prisonesr.length;
        int counter = 0;
        int steps = 0;
        while (counter<n){
            steps++;
            int p = (int)(Math.random()*n);
            if (p==0){
                if (!prisonesr[p]){
                    prisonesr[p] = true;
                    counter++;
                }
                if (!lamp){
                    lamp = true;
                    counter++;
                }
            }
            else {
                if (!prisonesr[p]&&lamp){
                    lamp = false;
                    prisonesr[p] = true;
                }
            }
        }
        return steps;

    }

    public static void main(String[] args){
        init(100);
        System.out.println(sulotion());
    }
}
