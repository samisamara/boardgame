package cmpsc.pkg390.group.project;

import java.util.Random;

public class CMPSC390GroupProject {

    public static void main(String[] args) {
        Ceelo();
    }
    
    public static void Ceelo(){
        Random rnd = new Random();
        
        //Deaker roll and print out
        System.out.println("Dealer's Roll");
        int DealerDie1 = rnd.nextInt(6) + 1;
        int DealerDie2 = rnd.nextInt(6) + 1;
        int DealerDie3 = rnd.nextInt(6) + 1;
        System.out.println(DealerDie1 + " " + DealerDie2 + " " + DealerDie3);
        
        //Player roll and print out
        System.out.println("Player's Roll");
        int PlayerDie1 = rnd.nextInt(6) + 1;
        int PlayerDie2 = rnd.nextInt(6) + 1;
        int PlayerDie3 = rnd.nextInt(6) + 1;
        System.out.println(PlayerDie1 + " " + PlayerDie2 + " " + PlayerDie3);
    }
}
