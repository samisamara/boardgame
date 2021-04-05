package cmpsc.pkg390.group.project;

import java.util.Random;
import java.util.Scanner;

public class CMPSC390GroupProject {

    public static void main(String[] args) {
        // total money
        // TODO code application logic here
        Scanner scnr = new Scanner(System.in);
        Double money;
        System.out.println("Hello Welcome to Casino Night!");

        System.out.println("Here is a list of available games");
        //List of games
        String[] games = {"Blackjack", "Baccarat", "Cee-lo"};
        for (int i = 0; i < games.length; i++) 
        {
            System.out.println("-" + games[i]);
        }
        System.out.println("");

        //Player enters how much money they would like to start with 
        //made money a double just so we can ask for whole number if they do not provide one.
        System.out.println("Enter amount of money you would like to start with: ");
        money = scnr.nextDouble();
        while (money % 1 != 0) 
        {
            System.out.println("Enter whole number");
            money = scnr.nextDouble();
        }

        System.out.println("Money: $" + money);

        boolean quit = false ;
        while(quit == false)
        {
            System.out.println("Please choose a game:");
            System.out.println(">1. [ Blackjack ]");
            System.out.println(">2. [ Baccarat ]");
            System.out.println(">3. [ Cee-lo ]");
            System.out.println(">4. [ Quit Game ]");

            //Player selection
            Scanner reader = new Scanner(System.in);
            int chooseGame = reader.nextInt();

                //loop until a valid selection is entered
                while(chooseGame < 1 || chooseGame > 4)
                {
                    System.out.println("Invalid selection, please re-enter.");
                    chooseGame = reader.nextInt();
                }

            //Choose game or quit
            switch(chooseGame)
            {
                case 1:
                      blackjack(money);
                    break;
                case 2:
                    baccarat(money); //Play baccarat using current Money
                    break;
                case 3:

                    break;
                case 4:
                    quit = true ; //Exit program
                    break;
            }
        }
    }
    
    public static void Ceelo(Double money){
        Scanner scnr = new Scanner(System.in);
        Random rnd = new Random();
        int bet = 0;
        int option;
        Boolean canPlay = false;
        
        do{
            //home page 
            System.out.print("Welcome to Cee-lo! Please select one of the following options:");
            System.out.println("> 1. Play a game");
            System.out.println("> 2. View rules");
            System.out.println("> 3. Back to menu");
            option = scnr.nextInt();
            
            //option select
            if(option == 1){
                System.out.println("Total Money: " + money);
                System.out.println("Place your bet");
                scnr.nextInt();
                while(bet > money || bet < 1){
                    System.out.println("Invalid  Value. Select a value greater than one and less than or equal to your total money");
                    System.out.println("Total Money: " + money);
                    scnr.nextInt();
                }
                canPlay = true;
            }
            else if(option == 2){
                System.out.println();
                System.out.println("---------------------------------------------------------------------------------------------------------");
                System.out.println("Cee-lo Rules");
                System.out.println("The player and the dealer will roll three dice");
                System.out.println("They will have up to three chances to the roll a hand");
                System.out.println("A hand is a pair and a single");
                System.out.println("The point value is the single. If there is no hand, then the point value is zero");
                System.out.println("The rolls will automatically done for you ans displayed each time.");
                System.out.println("In order to win, the player's value must be higher than the dealer's value");
                System.out.println("The payout is one to one meaning that your bet will be matched");
                System.out.println("The minimum bet is $1");
                System.out.println("Good Luck! Have Fun!"); 
                System.out.println("---------------------------------------------------------------------------------------------------------");
                System.out.println();
            }
            else if(option == 3){
                return;
            }
            else{
                System.out.println("Error: Invalid Input. Please select one of the following options:");
            }
        }while(canPlay == false);
        
        //Deaker dice and value
        int DealerDie1;
        int DealerDie2;
        int DealerDie3;
        int DealerValue = 0;
        
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
        int PlayerValue = 0;
        
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
        if(DealerValue>PlayerValue){
            money = money - bet;
        }
        else if(PlayerValue>DealerValue){
            money = money + bet;
        }
        else{
            money = money;
        }
        
    }
}
