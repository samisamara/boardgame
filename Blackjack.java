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
        double money = 500;
        //begins blackjack
        money = blackjack(money);
        
    }
    
    public static double blackjack(double money){
        //declares values
        Scanner scnr = new Scanner(System.in);
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
        check(playerTotal);
        
        return 0;
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
    public static void check(int player) {
        if (player <= 20) {
            System.out.println("You win!");
        }
        if (player > 21) {
            System.out.println("Player bust. You lose");
        }
        if (player == 21) {
            System.out.println("You win!");
        }
    }
    
}
