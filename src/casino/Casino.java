/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casino;

import java.util.Scanner;

/**
 *
 * @author David
 */
public class Casino {

    /**
     * @param args the command line arguments
     */
      public static void main(String[] args) {
        // TODO code application logic here
        Scanner scnr = new Scanner(System.in);
        Double money;
        System.out.println("Hello Welcome to Casino Night!");

        System.out.println("Here is a list of available games");
        //List of games
        String[] games = {"Blackjack", "Baccarat", "Cee-lo","Craps"};
        for (int i = 0; i < games.length; i++) {
            System.out.println("-" + games[i]);
        }
        System.out.println("");

        //Player enters how much money they would like to start with 
        //made money a double just so we can ask for whole number if they do not provide one.
        System.out.println("Enter amount of money you would like to start with: ");
        money = scnr.nextDouble();
        while (money % 1 != 0) {
            System.out.println("Enter whole number");
            money = scnr.nextDouble();
        }

        System.out.println("Money: $" + money);

        boolean quit = false;
        while (quit == false) {
            System.out.println("Please choose a game:");
            System.out.println(">1. [ Blackjack ]");
            System.out.println(">2. [ Baccarat ]");
            System.out.println(">3. [ Cee-lo ]");
            System.out.println(">4. [ Craps ]");
            System.out.println(">5. [ Help ]");
            System.out.println(">6. [ Quit Game ]");
            //Player selection
            Scanner reader = new Scanner(System.in);
            int chooseGame = reader.nextInt();

            //loop until a valid selection is entered
            while (chooseGame < 1 || chooseGame > 6) {
                System.out.println("Invalid selection, please re-enter.");
                chooseGame = reader.nextInt();
            }

            //Choose game or quit
            switch (chooseGame) {
                case 1:

                    break;
                case 2:
                    //baccarat(money); //Play baccarat using current Money
                    break;
                case 3:

                    break;
                case 4:
                    craps(money);
                    break;
                case 5:
                    help();
                    break;
                case 6:
                    quit = true; //Exit program
                    break;
            }

        }

    }

    public static void help() {
        System.out.println("Enter game you need help with:");
        boolean quit = false;
        while (quit == false) {
            System.out.println("Please choose a game you need help with:");
            System.out.println(">1. [ Blackjack ]");
            System.out.println(">2. [ Baccarat ]");
            System.out.println(">3. [ Cee-lo ]");
            System.out.println(">4. [ Craps ]");
            System.out.println(">5. [ Quit help ]");

            //Player selection
            Scanner reader = new Scanner(System.in);
            int chooseGame = reader.nextInt();

            //loop until a valid selection is entered
            while (chooseGame < 1 || chooseGame > 5) {
                System.out.println("Invalid selection, please re-enter.");
                chooseGame = reader.nextInt();
            }

            //Choose game or quit
            switch (chooseGame) {
                case 1:
                    System.out.println("The goal of blackjack is to beat the dealer's hand without going over 21.\n"
                            + "Face cards are worth 10. Aces are worth 1 or 11, whichever makes a better hand.\n"
                            + "Each player starts with two cards, one of the dealer's cards is hidden until the end.\n"
                            + "To 'Hit' is to ask for another card. To 'Stand' is to hold your total and end your turn.\n"
                            + "If you go over 21 you bust, and the dealer wins regardless of the dealer's hand.\n"
                            + "If you are dealt 21 from the start (Ace & 10), you got a blackjack.\n"
                            + "Blackjack usually means you win 1.5 the amount of your bet. Depends on the casino.\n"
                            + "Dealer will hit until his/her cards total 17 or higher.");
                    break;
                case 2:
                    System.out.println("If either the player or banker is dealt a total of eight or nine, both the player and banker stand.\n"
                            + "If the player’s total is five or less, then the player will receive another card. Otherwise, the player will stand.\n"
                            + "If the player stands, then the banker hits on a total of 5 or less.\n"
                            + "The final betting option, a tie, pays out 8-to-1. Conveniently, there are also sheets at the table for you to keep track of your score.");
                    break;
                case 3:

                    break;
                case 4:
                     System.out.println("Simplified Craps\n"
                            + "There are dozens of variations of standard craps.\n" + ""
                            + "This variant, , is a wonderful game to start with for the beginner gambler.\n"
                            + "In this game a player simply wins if she throws 2, 3, 4, 10, 11 or 12\n"
                            + "and loses if they roll 5, 6, 7, 8 or 9.");
                    break;
                case 5:
                    quit = true; //Exit program
                    break;
            }

        }

    }

}

