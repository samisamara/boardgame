
package craps;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author David
 */
public class Craps {

 
    public static double craps(Double money) {
        //initialize variables
        boolean play = true;
        Double mon = money;
        Double bet = 0.0;
        System.out.println(mon);
        Scanner scnr = new Scanner(System.in);
        Random rnd = new Random();

        //asks user to enter help to see rules or continue
        System.out.println("     Welcome to Craps!");
        System.out.println("To see rules enter -Help or -No to continue");
        String askHelp = scnr.next();
        if (askHelp.equalsIgnoreCase("help")) {
            help();
        } //enter bet before dice roll, if bet > player money, player must enter another bet
        else {
            while (play == true) {
                System.out.println("To begin enter your bet!");
                bet = scnr.nextDouble();
                while (bet > mon) {
                    System.out.println("Bet can't be more than $" + mon + "  Enter again:");
                    bet = scnr.nextDouble();
                }

                //dice roll
                int die1 = rnd.nextInt(6) + 1;
                int die2 = rnd.nextInt(6) + 1;
                int total = die1 + die2;
                //checks if win
                int[] win = {2, 3, 4, 10, 11, 12};
                int[] lose = {5, 6, 7, 8, 9};
                for (int i = 0; i < 6; i++) {
                    if (total == win[i]) {
                        System.out.println("Dice Roll: " + total);
                        bet = bet * 2;
                        System.out.println("YOU WIN: $" + bet);
                        mon = mon + bet;
                    }
                }
                //checks if lose 
                for (int k = 0; k < 5; k++) {
                    if (total == lose[k]) {
                        System.out.println("Dice Roll: " + total);
                        System.out.println("YOU LOSE: $" + bet);
                        mon = mon - bet;
                    }
                }
                //player money after dice roll
                System.out.println("Player Money: $" + mon);
                //ask to play again or exit
                System.out.println("Want to play again? Enter: Y/N");
                String ans = scnr.next();
                if (ans.equalsIgnoreCase("n")) {
                    play = false;
                }
            }

        }
        return mon;
    }
}
