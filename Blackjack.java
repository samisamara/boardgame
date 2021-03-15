/*
This program plays the game blackjack. The goal of the game is to collect cards 
and reach the value of 21 or close to it. Whoever ends with the highest value 
wins. If your total breaks past 21, you bust and you lose. If the dealer busts, 
you automatically win.
 */
package blackjack;
import java.util.*;
import java.io.*;
/**
 *
 * @author samis
 */
public class Blackjack {

    /**
     * @param args the command line arguments
     */
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
//                    baccarat(money); //Play baccarat using current Money
                    break;
                case 3:

                    break;
                case 4:
                    quit = true ; //Exit program
                    break;
            }
        }

    }
    
    public static double blackjack(double money){
        Scanner scnr = new Scanner(System.in);
        int bet=0;
        System.out.println("Welcome to Blackjack! Please select one of the following options");
        System.out.println(">1. [Play game]");
        System.out.println(">2. [View rules]");
        System.out.println(">3. [Go back]");
        int select = scnr.nextInt();
        do {
            if ((select > 3) || (select < 1)) {
                System.out.println("Error. Please select from the following options");
                System.out.println(">1. [Play game]");
                System.out.println(">2. [View rules]");
                System.out.println(">3. [Go back]");
                select = scnr.nextInt();
            }
            switch (select) {
                case 1:
                    System.out.println("Total Money: " + money);
                    System.out.println("Select your bet value:");
                    bet = scnr.nextInt();
                    while((bet > money) || (bet < 1)) {
                        System.out.println("Invalid bet value. Select a value larger than zero and less than or equal to your total money");
                        System.out.println("Total Money: " + money);
                        bet = scnr.nextInt();
                    }
                    break;
                case 2:
                    System.out.println("///////////////////////////////////////////////////////////////////////");
                    System.out.println("Rules Of Blackjack:");
                    System.out.println("You and the dealer will be recieving cards one at a time until you decide to stop");
                    System.out.println("Every card is worth their face value (ex: a 9 card is worth 9)");
                    System.out.println("An ace can either be a 1 or an 11");
                    System.out.println("Kings, Queens, and Jacks are worth 10");
                    System.out.println("The goal of the game is to reach 21, or higher than the dealer's hand");
                    System.out.println("If your hand goes past 21, you bust");
                    System.out.println("If the dealer busts, you automatically win");
                    System.out.println("///////////////////////////////////////////////////////////////////////");
                    System.out.println("");
                    System.out.println("Please select from the following options");
                    System.out.println(">1. [Play game]");
                    System.out.println(">2. [View rules]");
                    System.out.println(">3. [Go back]");
                    select = scnr.nextInt();
                    break;
                case 3:
                    return money;
            }
        } while (!(select==1));
        
        
        //declares values
        int playerTotal = 0;
        int numCard = 0;
        Random rn = new Random();
        //for loop to recieve two cards
        for (int i=0; i<2; i++){
            playerTotal = getCard(playerTotal, scnr);
            numCard++;
        }
        //value that checks which option the player chooses
        Character option;
        //this loop plays until player chooses no, reaches 21, or busts
        do {
        System.out.println("You have recieved " + numCard + " cards. Your current total is " + playerTotal + ". Would you like another card?");
        System.out.println("Select \"Y\" for yes, or \"N\" for no");
        option = scnr.next().charAt(0);
        option = Character.toUpperCase(option);
            while (option != 'Y' && option != 'N'){
                System.out.println("Invalid input");
                System.out.println("Select \"Y\" for yes, or \"N\" for no");
                option = scnr.next().charAt(0);
                option = Character.toUpperCase(option);
        }
        if (option.equals('Y')) {
            playerTotal = getCard(playerTotal, scnr);
            numCard++;
        }
        } while (playerTotal <= 20 && option.equals('Y'));
        System.out.println(playerTotal);
        money = check(playerTotal, money, bet);
        
        return money;
    }
    
    //this method gives you a card of a random value in blackjack
    public static int getCard(int playerTotal, Scanner scnr) {
        Random rn = new Random();
        int card = rn.nextInt(13)+1;
        //sends card to additional method to fix card value due to rules of blackjack
        card = cardValue(card, scnr);
        playerTotal = playerTotal + card;
        return playerTotal;
    }
    
    //this method alters the card value in coordination with the rules of blackjack
    public static int cardValue(int card, Scanner scnr){
        if (card >= 10) {
            switch (card) {
                case 11:
                    System.out.println("Card was a Joker. Card's value is 10");
                    break;
                case 12:
                    System.out.println("Card was a Queen. Card's value is 10");
                    break;
                case 13:
                    System.out.println("Card was a King. Card's value is 10");
                    break;
                default:
                    break;
            }
            card = 10;
        }
        else if (card == 1) {
            //option to make an ace a 1 or 11
            System.out.println("Your card was an ace. Would you like this card to be a 1 or an 11?");
            int num;
            card = scnr.nextInt();
            while ((card != 1) && (card != 11)) {
                System.out.println("Invalid number. Please select 1 or 11:");
                card = scnr.nextInt();
            }
        }
        System.out.println("Card value: " + card);
        return card;
    }
    
    //checks if thr player won or bust
    public static double check(int player, double money, int bet) {
        if (player <= 20) {
            System.out.println("You win!");
            System.out.println("Total money before playing: $" + money);
            System.out.println("Your bet: " + bet);
            System.out.println("You've earned 2x your bet");
            money = money + (bet*2);
            System.out.println("Total money after playing: $" + money);
        }
        if (player > 21) {
            System.out.println("Player bust. You lose");
            System.out.println("Total money before playing: $" + money);
            System.out.println("Your bet: " + bet);
            System.out.println("You've lost 2x your bet");
            money = money - (bet*2);
            System.out.println("Total money after playing: $" + money);
        }
        if (player == 21) {
            System.out.println("You win!");
            System.out.println("Total money before playing: $" + money);
            System.out.println("Your bet: " + bet);
            System.out.println("You've earned 2x your bet");
            money = money + (bet*2);
            System.out.println("Total money after playing: $" + money);
        }
        return money;
    }
    
}
