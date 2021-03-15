package cmpsc.pkg390.group.project;

import java.util.Random;
import java.util.Scanner;

public class CMPSC390GroupProject {

    public static void main(String[] args) {
        Ceelo();
    }
    
    public static void Ceelo(){
        Scanner scnr = new Scanner(System.in);
        Random rnd = new Random();
        
        int bet;
        String betOn;
        Boolean canPlay = false;
        
        do{
            System.out.println("Enter your bet. Enter player, dealer, or tie then the amount with a space in between");
            betOn = scnr.next();
            bet = scnr.nextInt();
            
            if(bet > money){
                System.out.println("Insufficient Funds");
            }
            else{
                if(betOn == "player" || betOn == "dealer" || betOn == "tie"){
                    canPlay = true;
                }
                else{
                    System.out.println("Improper Input");
                }
                
            }
            
        }while(canPlay == false);
        
        //Deaker dice and value
        int DealerDie1;
        int DealerDie2;
        int DealerDie3;
        int DealerValue;
        
        //Dealer roll 
        for(int i = 0; i < 3; i++){
            System.out.println("Dealer's Roll");
            DealerDie1 = rnd.nextInt(6) + 1;
            DealerDie2 = rnd.nextInt(6) + 1;
            DealerDie3 = rnd.nextInt(6) + 1;
            System.out.println(DealerDie1 + " " + DealerDie2 + " " + DealerDie3);
            
            if(DealerDie1==DealerDie2){
                DealerValue = DealerDie3;
                break;
            }
            else if(DealerDie1==DealerDie3){
                DealerValue = DealerDie2;
                break;
            }
            else if(DealerDie2==DealerDie3){
                DealerValue = DealerDie1;
                break;
            }
            else{
                DealerValue = 0;
            }
        }
        
        //Player dice and value
        System.out.println("Player's Roll");
        int PlayerDie1;
        int PlayerDie2;
        int PlayerDie3;
        int PlayerValue;
        
        //Player roll 
        for(int i = 0; i < 3; i++){
            System.out.println("Player's Roll");
            PlayerDie1 = rnd.nextInt(6) + 1;
            PlayerDie2 = rnd.nextInt(6) + 1;
            PlayerDie3 = rnd.nextInt(6) + 1;
            System.out.println(PlayerDie1 + " " + PlayerDie2 + " " + PlayerDie3);
            
            if(PlayerDie1==PlayerDie2){
                PlayerValue = PlayerDie3;
                break;
            }
            else if(PlayerDie1==PlayerDie3){
                PlayerValue = PlayerDie2;
                break;
            }
            else if(PlayerDie2==PlayerDie3){
                PlayerValue = PlayerDie1;
                break;
            }
            else{
                PlayerValue = 0;
            }
        }
        
        //results
        if(DealerValue>PlayerValue && betOn=="dealer"){
            money = money + bet;
        }
        else if(PlayerValue>DealerValue && betOn=="Player"){
            money = money + bet;
        }
        else if(DealerValue==PlayerValue && betOn=="tie"){
            money = money + bet;
        }
        else{
            money = money - bet;
        }
        
    }
}
