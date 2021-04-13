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
        int dealer = 0;
        Random rn = new Random();
        for (int i=0; i<2; i++) {
            dealer = getDealerCard(dealer);
        }
        //for loop to recieve two cards
        for (int i=0; i<2; i++){
            playerTotal = getCard(playerTotal, scnr);
            numCard++;
        }
        //value that checks which option the player chooses
        Character option;
        //this loop plays until player chooses no, reaches 21, or busts
        do {
        System.out.println("You have recieved " + numCard + " cards. Your current total is " + playerTotal + ".");
        System.out.println("The dealer's total is " + dealer + ". Would you like another card?");
        System.out.println("Select \"Y\" for yes, or \"N\" for no");
        option = scnr.next().charAt(0);
        option = Character.toUpperCase(option);
            while (option != 'Y' && option != 'N'){
                System.out.println("Invalid input");
                System.out.println("Select \"Y\" for yes, or \"N\" for no");
                option = scnr.next().charAt(0);
                option = Character.toUpperCase(option);
        }
        // if the dealer has a total less than 17, get new card
        if (option.equals('Y')) {
            if (dealer < 17) {
                dealer = getDealerCard(dealer);
            }
            playerTotal = getCard(playerTotal, scnr);
            numCard++;
        }
        //option of whether the player wants to keep going or not
        } while (playerTotal <= 20 && option.equals('Y') && dealer <= 21);
        System.out.println(playerTotal);
        money = check(playerTotal, money, bet, dealer);
        
        return money;
    }
    
    //this method gives you a card of a random value in blackjack
    public static int getCard(int playerTotal, Scanner scnr) {
        //randomly picks a number from 1-13 and then sends number to method to assign value
        Random rn = new Random();
        int card = rn.nextInt(13)+1;
        //sends card to additional method to fix card value due to rules of blackjack
        card = cardValue(card, scnr);
        playerTotal = playerTotal + card;
        return playerTotal;
    }
    
    //this method alters the card value in coordination with the rules of blackjack
    public static int cardValue(int card, Scanner scnr){
        //assigns a card value based on the number
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
    
    public static int getDealerCard(int dealer) {
        //gives the dealer a card and adds to dealer's total
        Random rn = new Random();
        int card = rn.nextInt(13)+1;
        if (card > 10) {
            card = 10;
        }
        if (card == 1) {
            if ((dealer + card) > 21) {
                card = 1;
            }
            else {
                card = 11;
            }
        }
        return (dealer + card);
    }
    
    //checks if thr player won or bust
    public static double check(int player, double money, int bet, int dealer) {
        // this if statement only functions when the dealer busts
        if (dealer > 21) {
            System.out.println("Dealer busts...You win!");
            System.out.println("Total money before playing: $" + money);
            System.out.println("Your bet: " + bet);
            System.out.println("You've earned your bet");
            money = money + bet;
            System.out.println("Total money after playing: $" + money);  
        }
        // this if statement only functions when the player beats the dealer normally
        if ((player <= 20) && (player > dealer)) {
            System.out.println("You win!");
            System.out.println("Total money before playing: $" + money);
            System.out.println("Your bet: " + bet);
            System.out.println("You've earned your bet");
            money = money + bet;
            System.out.println("Total money after playing: $" + money);
        }
        // this if statement only functions when the player busts
        if (player > 21) {
            System.out.println("Player bust. You lose");
            System.out.println("Total money before playing: $" + money);
            System.out.println("Your bet: " + bet);
            System.out.println("You've lost your bet");
            money = money - bet;
            System.out.println("Total money after playing: $" + money);
        }
        // this if statement only functions when the player beats the dealer normally
        if ((player < 21) && (dealer > player) && (dealer < 21)) {
            System.out.println("Dealer's value was greater. You lose");
            System.out.println("Total money before playing: $" + money);
            System.out.println("Your bet: " + bet);
            System.out.println("You've lost your bet");
            money = money - bet;
            System.out.println("Total money after playing: $" + money);
        }
        // this if statement only functions when the player gets 21 exactly
        if (player == 21) {
            System.out.println("You win!");
            System.out.println("Total money before playing: $" + money);
            System.out.println("Your bet: " + bet);
            System.out.println("You've earned your bet");
            money = money + bet;
            System.out.println("Total money after playing: $" + money);
        }
        return money;
    }
    
}
