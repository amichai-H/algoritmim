public class FightProblem {
    public class Shooter{
        String name;
        int chancToHeat;//0-100
        boolean live = true;
        public Shooter(String name,int chancToHeat){
            this.name = name;
            this.chancToHeat = chancToHeat;
        }
        public boolean shoot(boolean inAir,Shooter other ){
            if (!isAlive()) return false;
            if (inAir) return false;
            int r = (int)(Math.random()*100)+1;
            if (chancToHeat>=r){
                System.out.println(name+" kill " + other.name);
                other.live = false;
                return true;
            }
            else {
                System.out.println(name+" miss " + other.name);

                return false;
            }
        }
        public boolean isAlive(){
            return live;
        }

        public String getName() {
            return name;
        }
    }
    public String sulotion(){
        Shooter C = new Shooter("C",100);
        Shooter B = new Shooter("B",80);
        Shooter D= new Shooter("D",50);
        Shooter[] order = setOrder(C,B,D);
        int i = 0;
        while (moreThenOneisAlive(order)){
            i = i%3;
            String nowTurn = order[i].getName();
            switch (nowTurn){
                case "C":
                    if (B.isAlive()) C.shoot(false,B);
                    else C.shoot(false,D);
                    break;
                case "B":
                    if (C.isAlive()) B.shoot(false,C);
                    else B.shoot(false,D);
                    break;
                case "D":
                    if (C.isAlive()&&B.isAlive()){
                        D.shoot(true,null);
                    }
                    else {
                        if (C.isAlive()) D.shoot(false,C);
                        else D.shoot(false,B);
                    }
            }
            i++;

        }
        if (C.isAlive()) return "C win";
        if (B.isAlive()) return "B win";
        return "D Win";

    }
    public static void main(String[] args){
        FightProblem fightProblem = new FightProblem();
        System.out.println(fightProblem.sulotion());
    }

    private boolean moreThenOneisAlive(Shooter[] order) {
        boolean ans = true;
        boolean oneAlive = false;
        for (int i = 0;i<order.length&&ans;i++){
            if (oneAlive&&order[i].isAlive()){
                ans = false;
            }
            if (!oneAlive&&order[i].isAlive()){
                oneAlive = true;
            }

        }
        return !ans;
    }

    private Shooter[] setOrder(Shooter C, Shooter B, Shooter D) {//set random order
        Shooter[] shooter = {C, B, D};
        Shooter[] ans = new  Shooter[3];
        int r = (int) (Math.random() * 3);
        ans[0] = shooter[r];
        int r2 = (int) (Math.random() * 2) + 1;
        r2 = r + r2;
        r2 = r2 % 3;
        ans[1] = shooter[r2];
        int left = 3-r-r2;
        ans[2] = shooter[left];
        return ans;
    }

}
